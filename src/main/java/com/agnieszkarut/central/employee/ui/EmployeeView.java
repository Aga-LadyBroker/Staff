package com.agnieszkarut.central.employee.ui;

import com.agnieszkarut.central.employee.domain.Employee;
import com.agnieszkarut.central.employee.domain.EmployeeFactory;
import com.agnieszkarut.central.employee.domain.EmployeeJobType;
import com.agnieszkarut.central.employee.domain.EmployeeService;
import com.agnieszkarut.foundation.ui.baseview.BaseView;
import com.agnieszkarut.views.MainLayout;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Pracownicy")
@Route(value = "gui/central/employees/:id?/:action?(edit)", layout = MainLayout.class)
@Uses(Icon.class)
public class EmployeeView extends BaseView <Employee> {

    TextField firstName;
    TextField lastName;
    TextField pesel;
    TextField address;
    TextField email;
    TextField phone;
    DatePicker dateOfEmployment;
    ComboBox<EmployeeJobType> type;
    TextField medicalUnitId;

    public EmployeeView(EmployeeFactory factory, EmployeeService service) {
        super(Employee.class, factory, service, "gui/central/employees/%s/edit");
        createLayout();
    }

    @Override
    protected void configureGrid() {
        grid.addColumn("firstName").setAutoWidth(true).setHeader(i18n("firstName"));
        grid.addColumn("lastName").setAutoWidth(true).setHeader(i18n("lastName"));
        grid.addColumn("pesel").setAutoWidth(true).setHeader(i18n("pesel"));
        grid.addColumn("address").setAutoWidth(true).setHeader(i18n("address"));
        grid.addColumn("email").setAutoWidth(true).setHeader(i18n("email"));
        grid.addColumn("phone").setAutoWidth(true).setHeader(i18n("phone"));
        grid.addColumn("dateOfEmployment").setAutoWidth(true).setHeader(i18n("dateOfEmployment"));
        grid.addColumn(t -> t.getType() == null ? "" : i18n(EmployeeJobType.class, t.getType().name())).setAutoWidth(true)
                .setHeader(i18n("type"));
        grid.addColumn("medicalUnitId").setAutoWidth(true).setHeader(i18n("medicalUnitId"));
    }

    @Override
    protected FormLayout createEditorForm(Div editorDiv) {

        FormLayout formLayout = new FormLayout();

        firstName = new TextField(i18n("firstName"));
        lastName = new TextField(i18n("lastName"));
        pesel = new TextField(i18n("pesel"));
        address = new TextField(i18n("address"));
        email = new TextField(i18n("email"));
        phone = new TextField(i18n("phone"));
        dateOfEmployment = new DatePicker(i18n("dateOfEmployment"));
        type = new ComboBox<>(i18n("type"));
        medicalUnitId = new TextField(i18n(" medicalUnitId")) ;

        type.setItems(EmployeeJobType.values());
        type.setItemLabelGenerator(t -> i18n(EmployeeJobType.class, t.name()));

        formLayout.add(firstName, lastName, pesel, address, email, phone, dateOfEmployment, type,medicalUnitId);
        return formLayout;
    }
}

