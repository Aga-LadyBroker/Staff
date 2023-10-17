package com.agnieszkarut.central.medicalunit.ui;

import com.agnieszkarut.central.employee.domain.EmployeeJobType;
import com.agnieszkarut.central.medicalunit.domain.*;
import com.agnieszkarut.foundation.ui.baseview.BaseView;
import com.agnieszkarut.views.MainLayout;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Jednostki medyczne")
@Route(value = "gui/central/medical-units/:id?/:action?(edit)", layout = MainLayout.class)
@Uses(Icon.class)
public class MedicalUnitView extends BaseView <MedicalUnit> {

    TextField medicalUnitName;
    TextField address;
    ComboBox<MedicalUnitTypeOfActivity> activity;
    TextField parentMedicalUnitId;


    public MedicalUnitView(MedicalUnitFactory factory, MedicalUnitService service) {
        super(MedicalUnit.class, factory, service, "gui/central/medical-units/%s/edit");
        createLayout();
    }

    @Override
    protected void configureGrid() {
        grid.addColumn("medicalUnitName").setAutoWidth(true).setHeader(i18n("medicalUnitName"));
        grid.addColumn("address").setAutoWidth(true).setHeader(i18n("address"));
        grid.addColumn(a -> a.getActivity() == null ? "" : i18n(EmployeeJobType.class, a.getActivity().name())).setAutoWidth(true)
                .setHeader(i18n("activity"));
        grid.addColumn("parentMedicalUnitId").setAutoWidth(true).setHeader(i18n("parentMedicalUnitId"));
    }

    @Override
    protected FormLayout createEditorForm(Div editorDiv) {

        FormLayout formLayout = new FormLayout();

        medicalUnitName = new TextField(i18n("medicalUnitName"));
        address= new TextField(i18n("address"));
        activity = new ComboBox<>(i18n("activity"));
        parentMedicalUnitId= new TextField(i18n("parentMedicalUnitId"));

        activity.setItems(MedicalUnitTypeOfActivity.values());
        activity.setItemLabelGenerator(a -> i18n(MedicalUnitTypeOfActivity.class, a.name()));

        formLayout.add(medicalUnitName, address, activity, parentMedicalUnitId);
        return formLayout;
    }
}
