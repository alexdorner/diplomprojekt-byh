package KisModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class PatientAppointmentK  {



    public String creation;
    public String doctype;

@JsonIgnore
    public String getCreation() {
        return creation;
    }
    @JsonIgnore
    public void setCreation(String creation) {
        this.creation = creation;
    }
    @JsonIgnore
    public String getDoctype() {
        return doctype;
    }
    @JsonIgnore
    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }
    @JsonIgnore
    public String getOwner() {
        return owner;
    }
    @JsonIgnore
    public void setOwner(String owner) {
        this.owner = owner;
    }
    @JsonIgnore
    public int getDuration() {
        return duration;
    }
    @JsonIgnore
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
    @JsonIgnore
    public int getInvoiced() {
        return invoiced;
    }
    @JsonIgnore
    public void setInvoiced(int invoiced) {
        this.invoiced = invoiced;
    }
    @JsonIgnore
    public String getModified_by() {
        return modified_by;
    }
    @JsonIgnore
    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }
    @JsonIgnore
    public double getPaid_amount() {
        return paid_amount;
    }
    @JsonIgnore
    public void setPaid_amount(double paid_amount) {
        this.paid_amount = paid_amount;
    }
    @JsonIgnore
    public int getReminded() {
        return reminded;
    }
    @JsonIgnore
    public void setReminded(int reminded) {
        this.reminded = reminded;
    }

    public String getPatient_name() {
        return patient_name;
    }
    @JsonIgnore
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @JsonIgnore
    public int getDocstatus() {
        return docstatus;
    }
    @JsonIgnore
    public void setDocstatus(int docstatus) {
        this.docstatus = docstatus;
    }
    @JsonIgnore
    public String getStatus() {
        return status;
    }
    @JsonIgnore
    public void setStatus(String status) {
        this.status = status;
    }
    @JsonIgnore
    public String getPractitioner() {
        return practitioner;
    }
    @JsonIgnore
    public void setPractitioner(String practitioner) {
        this.practitioner = practitioner;
    }

    public String getAppointment_type() {
        return appointment_type;
    }

    public void setAppointment_type(String appointment_type) {
        this.appointment_type = appointment_type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    @JsonIgnore
    public String getReferring_practitioner() {
        return referring_practitioner;
    }
    @JsonIgnore
    public void setReferring_practitioner(String referring_practitioner) {
        this.referring_practitioner = referring_practitioner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonIgnore
    public int getIdx() {
        return idx;
    }
    @JsonIgnore
    public void setIdx(int idx) {
        this.idx = idx;
    }
    @JsonIgnore
    public String getPatient_sex() {
        return patient_sex;
    }
    @JsonIgnore
    public void setPatient_sex(String patient_sex) {
        this.patient_sex = patient_sex;
    }
    @JsonIgnore
    public String getModified() {
        return modified;
    }
    @JsonIgnore
    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getService_unit() {
        return service_unit;
    }

    public void setService_unit(String service_unit) {
        this.service_unit = service_unit;
    }



    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String owner;
    public int duration;
    public String patient;
    public int invoiced;
    public String modified_by;
    public String appointment_date;
    public double paid_amount;
    public int reminded;
    public String patient_name;
    public String department;
    public int docstatus;
    public String status;
    public String practitioner;
    public String appointment_type;
    public String company;
    public String referring_practitioner;
    public String name;
    public int idx;
    public String patient_sex;
    public String modified;
    public String service_unit;
    public String appointment_time;
}

// equvalent zu appointment