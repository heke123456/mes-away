<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="开票日期" prop="invoiceCreateTime">
        <el-date-picker
          clearable
          v-model="queryParams.invoiceCreateTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开票日期"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="开票数量" prop="invoiceNumer">
        <el-input
          v-model="queryParams.invoiceNumer"
          placeholder="请输入开票数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="对账日期" prop="reconciliationDate">
        <el-date-picker
          clearable
          v-model="queryParams.reconciliationDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择对账日期"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="客户对账人员" prop="customerReconciliationPersonnel">
        <el-input
          v-model="queryParams.customerReconciliationPersonnel"
          placeholder="请输入客户对账人员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['finance:invoice:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['finance:invoice:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['finance:invoice:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['finance:invoice:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="invoiceList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="发票编号" align="center" prop="id" />
      <el-table-column label="开票类型" align="center" prop="invoiceType" />
      <el-table-column
        label="开票日期"
        align="center"
        prop="invoiceCreateTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{
            parseTime(scope.row.invoiceCreateTime, "{y}-{m}-{d}")
          }}</span>
        </template>
      </el-table-column>
      <el-table-column label="开票数量" align="center" prop="invoiceNumer" />
      <el-table-column label="税率" align="center" prop="taxRate" />
      <el-table-column label="税费" align="center" prop="taxation" />
      <el-table-column
        type="number"
        label="销售单价(不含税)"
        align="center"
        prop="salesUnitPriceExcludingTax"
      />
      <el-table-column
        label="销售单价(含税)"
        align="center"
        prop="salesUnitPriceIncludingTax"
      />
      <el-table-column
        label="销售金额(不含税)"
        align="center"
        prop="consumptionAmountExcludingTax"
      />
      <el-table-column
        label="销售金额(含税)"
        align="center"
        prop="consumptionAmountIncludingTax"
      />
      <el-table-column
        label="对账日期"
        align="center"
        prop="reconciliationDate"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{
            parseTime(scope.row.reconciliationDate, "{y}-{m}-{d}")
          }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="客户对账人员"
        align="center"
        prop="customerReconciliationPersonnel"
      />
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['finance:invoice:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['finance:invoice:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['finance:invoice:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        :disabled="view_open"
      >
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item v-if="isadd" label="发票编号" prop="id">
              <el-input v-model="form.id" placeholder="请输入发票编号" />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="开票日期" prop="invoiceCreateTime">
              <el-date-picker
                clearable
                v-model="form.invoiceCreateTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择开票日期"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="开票类型" prop="invoiceType">
              <el-input
                v-model="form.invoiceType"
                placeholder="请输入开票类型"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="开票数量" prop="invoiceNumer">
              <el-input
                type="number"
                v-model="form.invoiceNumer"
                placeholder="请输入开票数量"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="税率" prop="taxRate">
              <el-input v-model="form.taxRate" placeholder="请输入税率" />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="税费" prop="taxation">
              <el-input
                type="number"
                v-model="form.taxation"
                placeholder="请输入税费"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item
              label="销售单价(不含税)"
              prop="salesUnitPriceExcludingTax"
            >
              <el-input
                type="number"
                v-model="form.salesUnitPriceExcludingTax"
                placeholder="请输入销售单价(不含税)"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item
              label="销售单价(含税)"
              prop="salesUnitPriceIncludingTax"
            >
              <el-input
                type="number"
                v-model="form.salesUnitPriceIncludingTax"
                placeholder="请输入销售单价(含税)"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item
              label="销售金额(不含税)"
              prop="consumptionAmountExcludingTax"
            >
              <el-input
                type="number"
                v-model="form.consumptionAmountExcludingTax"
                placeholder="请输入销售金额(不含税)"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item
              label="销售金额(含税)"
              prop="consumptionAmountIncludingTax"
            >
              <el-input
                type="number"
                v-model="form.consumptionAmountIncludingTax"
                placeholder="请输入销售金额(含税)"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="对账日期" prop="reconciliationDate">
              <el-date-picker
                clearable
                v-model="form.reconciliationDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择对账日期"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item
              label="客户对账人员"
              prop="customerReconciliationPersonnel"
            >
              <el-input
                v-model="form.customerReconciliationPersonnel"
                placeholder="请输入客户对账人员"
              />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer" v-if="!view_open">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listInvoice,
  getInvoice,
  delInvoice,
  addInvoice,
  updateInvoice,
} from "@/api/finance/invoice";

export default {
  name: "Invoice",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 发票信息表格数据
      invoiceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否新建
      isadd: true,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        invoiceType: null,
        invoiceCreateTime: null,
        invoiceNumer: null,
        reconciliationDate: null,
        customerReconciliationPersonnel: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [{ required: true, message: "发票编号不能为空", trigger: "blur" }],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询发票信息列表 */
    getList() {
      this.loading = true;
      listInvoice(this.queryParams).then((response) => {
        this.invoiceList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        invoiceType: null,
        invoiceCreateTime: null,
        invoiceNumer: null,
        taxRate: null,
        taxation: null,
        salesUnitPriceExcludingTax: null,
        salesUnitPriceIncludingTax: null,
        consumptionAmountExcludingTax: null,
        consumptionAmountIncludingTax: null,
        reconciliationDate: null,
        customerReconciliationPersonnel: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    handleView(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getInvoice(id).then((response) => {
        this.form = response.data;
        this.view_open = true;
        this.open = true;
        this.title = "修改发票信息";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.view_open = false;
      this.isadd = true;
      this.open = true;
      this.title = "添加发票信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.view_open = false;
      this.isadd = false;
      const id = row.id || this.ids;
      getInvoice(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改发票信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateInvoice(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInvoice(this.form).then((response) => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal
        .confirm('是否确认删除发票信息编号为"' + ids + '"的数据项？')
        .then(function () {
          return delInvoice(ids);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "finance/invoice/export",
        {
          ...this.queryParams,
        },
        `invoice_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
