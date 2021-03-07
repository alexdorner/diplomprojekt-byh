package KisModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Company {

    public String domain;
    public double monthly_sales_target;
    public String creation;
    public String accumulated_depreciation_account;
    public String default_employee_advance_account;
    public String exchange_gain_loss_account;
    public String parent_company;
    public int allow_account_creation_against_child_company;
    public String owner;
    public String cost_center;
    public String transactions_annual_history;
    public String default_currency;
    public String modified_by;
    public String doctype;
    public String existing_company;
    public String default_income_account;
    public String depreciation_cost_center;
    public String disposal_account;
    public String company_name;
    public String expenses_included_in_valuation;
    public String default_bank_account;
    public int docstatus;
    public String default_receivable_account;
    public String round_off_account;
    public String default_payroll_payable_account;
    public int rgt;
    public String asset_received_but_not_billed;
    public int is_group;
    public String write_off_account;
    public String round_off_cost_center;
    public String default_payable_account;
    public String stock_adjustment_account;
    public String abbr;
    public String create_chart_of_accounts_based_on;
    public double standard_working_hours;
    public double total_monthly_sales;
    public String default_inventory_account;
    public int enable_perpetual_inventory;
    public double credit_limit;
    public String stock_received_but_not_billed;
    public String name;
    public int idx;
    public int lft;
    public String country;
    public String expenses_included_in_asset_valuation;
    public String modified;
    public String old_parent;
    public String default_expense_account;
    public String depreciation_expense_account;
    public String default_cash_account;

    @JsonIgnore
    public String getDomain() {
        return domain;
    }

    @JsonIgnore
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @JsonIgnore
    public double getMonthly_sales_target() {
        return monthly_sales_target;
    }

    @JsonIgnore
    public void setMonthly_sales_target(double monthly_sales_target) {
        this.monthly_sales_target = monthly_sales_target;
    }

    @JsonIgnore
    public String getCreation() {
        return creation;
    }

    @JsonIgnore
    public void setCreation(String creation) {
        this.creation = creation;
    }

    @JsonIgnore
    public String getAccumulated_depreciation_account() {
        return accumulated_depreciation_account;
    }

    @JsonIgnore
    public void setAccumulated_depreciation_account(String accumulated_depreciation_account) {
        this.accumulated_depreciation_account = accumulated_depreciation_account;
    }

    @JsonIgnore
    public String getDefault_employee_advance_account() {
        return default_employee_advance_account;
    }

    @JsonIgnore
    public void setDefault_employee_advance_account(String default_employee_advance_account) {
        this.default_employee_advance_account = default_employee_advance_account;
    }

    @JsonIgnore
    public String getExchange_gain_loss_account() {
        return exchange_gain_loss_account;
    }

    @JsonIgnore
    public void setExchange_gain_loss_account(String exchange_gain_loss_account) {
        this.exchange_gain_loss_account = exchange_gain_loss_account;
    }

    @JsonIgnore
    public String getParent_company() {
        return parent_company;
    }

    @JsonIgnore
    public void setParent_company(String parent_company) {
        this.parent_company = parent_company;
    }

    @JsonIgnore
    public int getAllow_account_creation_against_child_company() {
        return allow_account_creation_against_child_company;
    }

    @JsonIgnore
    public void setAllow_account_creation_against_child_company(int allow_account_creation_against_child_company) {
        this.allow_account_creation_against_child_company = allow_account_creation_against_child_company;
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
    public String getCost_center() {
        return cost_center;
    }

    @JsonIgnore
    public void setCost_center(String cost_center) {
        this.cost_center = cost_center;
    }

    @JsonIgnore
    public String getTransactions_annual_history() {
        return transactions_annual_history;
    }

    @JsonIgnore
    public void setTransactions_annual_history(String transactions_annual_history) {
        this.transactions_annual_history = transactions_annual_history;
    }

    @JsonIgnore
    public String getDefault_currency() {
        return default_currency;
    }

    @JsonIgnore
    public void setDefault_currency(String default_currency) {
        this.default_currency = default_currency;
    }

    @JsonIgnore
    public String getModified_by() {
        return modified_by;
    }

    @JsonIgnore
    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
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
    public String getExisting_company() {
        return existing_company;
    }

    @JsonIgnore
    public void setExisting_company(String existing_company) {
        this.existing_company = existing_company;
    }

    @JsonIgnore
    public String getDefault_income_account() {
        return default_income_account;
    }

    @JsonIgnore
    public void setDefault_income_account(String default_income_account) {
        this.default_income_account = default_income_account;
    }

    @JsonIgnore
    public String getDepreciation_cost_center() {
        return depreciation_cost_center;
    }

    @JsonIgnore
    public void setDepreciation_cost_center(String depreciation_cost_center) {
        this.depreciation_cost_center = depreciation_cost_center;
    }

    @JsonIgnore
    public String getDisposal_account() {
        return disposal_account;
    }

    @JsonIgnore
    public void setDisposal_account(String disposal_account) {
        this.disposal_account = disposal_account;
    }

    @JsonIgnore
    public String getCompany_name() {
        return company_name;
    }

    @JsonIgnore
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    @JsonIgnore
    public String getExpenses_included_in_valuation() {
        return expenses_included_in_valuation;
    }

    @JsonIgnore
    public void setExpenses_included_in_valuation(String expenses_included_in_valuation) {
        this.expenses_included_in_valuation = expenses_included_in_valuation;
    }

    @JsonIgnore
    public String getDefault_bank_account() {
        return default_bank_account;
    }

    @JsonIgnore
    public void setDefault_bank_account(String default_bank_account) {
        this.default_bank_account = default_bank_account;
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
    public String getDefault_receivable_account() {
        return default_receivable_account;
    }

    @JsonIgnore
    public void setDefault_receivable_account(String default_receivable_account) {
        this.default_receivable_account = default_receivable_account;
    }

    @JsonIgnore
    public String getRound_off_account() {
        return round_off_account;
    }

    @JsonIgnore
    public void setRound_off_account(String round_off_account) {
        this.round_off_account = round_off_account;
    }

    @JsonIgnore
    public String getDefault_payroll_payable_account() {
        return default_payroll_payable_account;
    }

    @JsonIgnore
    public void setDefault_payroll_payable_account(String default_payroll_payable_account) {
        this.default_payroll_payable_account = default_payroll_payable_account;
    }

    @JsonIgnore
    public int getRgt() {
        return rgt;
    }

    @JsonIgnore
    public void setRgt(int rgt) {
        this.rgt = rgt;
    }

    @JsonIgnore
    public String getAsset_received_but_not_billed() {
        return asset_received_but_not_billed;
    }

    @JsonIgnore
    public void setAsset_received_but_not_billed(String asset_received_but_not_billed) {
        this.asset_received_but_not_billed = asset_received_but_not_billed;
    }

    @JsonIgnore
    public int getIs_group() {
        return is_group;
    }

    @JsonIgnore
    public void setIs_group(int is_group) {
        this.is_group = is_group;
    }

    @JsonIgnore
    public String getWrite_off_account() {
        return write_off_account;
    }

    @JsonIgnore
    public void setWrite_off_account(String write_off_account) {
        this.write_off_account = write_off_account;
    }

    @JsonIgnore
    public String getRound_off_cost_center() {
        return round_off_cost_center;
    }

    @JsonIgnore
    public void setRound_off_cost_center(String round_off_cost_center) {
        this.round_off_cost_center = round_off_cost_center;
    }

    @JsonIgnore
    public String getDefault_payable_account() {
        return default_payable_account;
    }

    @JsonIgnore
    public void setDefault_payable_account(String default_payable_account) {
        this.default_payable_account = default_payable_account;
    }

    @JsonIgnore
    public String getStock_adjustment_account() {
        return stock_adjustment_account;
    }

    @JsonIgnore
    public void setStock_adjustment_account(String stock_adjustment_account) {
        this.stock_adjustment_account = stock_adjustment_account;
    }

    @JsonIgnore
    public String getAbbr() {
        return abbr;
    }

    @JsonIgnore
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    @JsonIgnore
    public String getCreate_chart_of_accounts_based_on() {
        return create_chart_of_accounts_based_on;
    }

    @JsonIgnore
    public void setCreate_chart_of_accounts_based_on(String create_chart_of_accounts_based_on) {
        this.create_chart_of_accounts_based_on = create_chart_of_accounts_based_on;
    }

    @JsonIgnore
    public double getStandard_working_hours() {
        return standard_working_hours;
    }

    @JsonIgnore
    public void setStandard_working_hours(double standard_working_hours) {
        this.standard_working_hours = standard_working_hours;
    }

    @JsonIgnore
    public double getTotal_monthly_sales() {
        return total_monthly_sales;
    }

    @JsonIgnore
    public void setTotal_monthly_sales(double total_monthly_sales) {
        this.total_monthly_sales = total_monthly_sales;
    }

    @JsonIgnore
    public String getDefault_inventory_account() {
        return default_inventory_account;
    }

    @JsonIgnore
    public void setDefault_inventory_account(String default_inventory_account) {
        this.default_inventory_account = default_inventory_account;
    }

    @JsonIgnore
    public int getEnable_perpetual_inventory() {
        return enable_perpetual_inventory;
    }

    @JsonIgnore
    public void setEnable_perpetual_inventory(int enable_perpetual_inventory) {
        this.enable_perpetual_inventory = enable_perpetual_inventory;
    }

    @JsonIgnore
    public double getCredit_limit() {
        return credit_limit;
    }

    @JsonIgnore
    public void setCredit_limit(double credit_limit) {
        this.credit_limit = credit_limit;
    }

    @JsonIgnore
    public String getStock_received_but_not_billed() {
        return stock_received_but_not_billed;
    }

    @JsonIgnore
    public void setStock_received_but_not_billed(String stock_received_but_not_billed) {
        this.stock_received_but_not_billed = stock_received_but_not_billed;
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
    public int getLft() {
        return lft;
    }

    @JsonIgnore
    public void setLft(int lft) {
        this.lft = lft;
    }

    @JsonIgnore
    public String getCountry() {
        return country;
    }

    @JsonIgnore
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonIgnore
    public String getExpenses_included_in_asset_valuation() {
        return expenses_included_in_asset_valuation;
    }

    @JsonIgnore
    public void setExpenses_included_in_asset_valuation(String expenses_included_in_asset_valuation) {
        this.expenses_included_in_asset_valuation = expenses_included_in_asset_valuation;
    }

    @JsonIgnore
    public String getModified() {
        return modified;
    }

    @JsonIgnore
    public void setModified(String modified) {
        this.modified = modified;
    }

    @JsonIgnore
    public String getOld_parent() {
        return old_parent;
    }

    @JsonIgnore
    public void setOld_parent(String old_parent) {
        this.old_parent = old_parent;
    }

    @JsonIgnore
    public String getDefault_expense_account() {
        return default_expense_account;
    }

    @JsonIgnore
    public void setDefault_expense_account(String default_expense_account) {
        this.default_expense_account = default_expense_account;
    }

    @JsonIgnore
    public String getDepreciation_expense_account() {
        return depreciation_expense_account;
    }

    @JsonIgnore
    public void setDepreciation_expense_account(String depreciation_expense_account) {
        this.depreciation_expense_account = depreciation_expense_account;
    }

    @JsonIgnore
    public String getDefault_cash_account() {
        return default_cash_account;
    }

    @JsonIgnore
    public void setDefault_cash_account(String default_cash_account) {
        this.default_cash_account = default_cash_account;
    }

    @JsonIgnore
    public String getCapital_work_in_progress_account() {
        return capital_work_in_progress_account;
    }

    @JsonIgnore
    public void setCapital_work_in_progress_account(String capital_work_in_progress_account) {
        this.capital_work_in_progress_account = capital_work_in_progress_account;
    }

    @JsonIgnore
    public String capital_work_in_progress_account;
}
