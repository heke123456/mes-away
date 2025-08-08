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
      <el-row :gutter="1">
        <el-col :span="21">
          <div
            style="overflow-x: auto; scrollbar-width: none; white-space: nowrap"
          >
            <el-form-item label="发票税率" prop="invoiceTaxRate">
              <el-input
                v-model="queryParams.invoiceTaxRate"
                placeholder="请输入发票税率"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item
              label="不含税采购单价"
              prop="purchaseUnitPriceExcludingTax"
            >
              <el-input
                v-model="queryParams.purchaseUnitPriceExcludingTax"
                placeholder="请输入不含税采购单价"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item
              label="含税采购单价"
              prop="purchaseUnitPriceIncludingTax"
            >
              <el-input
                v-model="queryParams.purchaseUnitPriceIncludingTax"
                placeholder="请输入含税采购单价"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="3">
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
        </el-col>
      </el-row>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['finance:receiptinvoice:add']"
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
          v-hasPermi="['finance:receiptinvoice:edit']"
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
          v-hasPermi="['finance:receiptinvoice:remove']"
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
          v-hasPermi="['finance:receiptinvoice:export']"
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
      :data="receiptinvoiceList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="入库发票编号"
        align="center"
        prop="receiptInvoiceID"
      />
      <el-table-column label="发票类型" align="center" prop="invoiceType" />
      <el-table-column label="发票税率" align="center" prop="invoiceTaxRate" />
      <el-table-column
        label="不含税采购单价"
        align="center"
        prop="purchaseUnitPriceExcludingTax"
      />
      <el-table-column
        label="含税采购单价"
        align="center"
        prop="purchaseUnitPriceIncludingTax"
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
            v-hasPermi="['finance:receiptinvoice:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['finance:receiptinvoice:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['finance:receiptinvoice:remove']"
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

    <!-- 添加或修改入库发票信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        :disabled="view_open"
      >
        <el-form-item label="发票编号" prop="receiptInvoiceID">
          <el-input
            v-model="form.receiptInvoiceID"
            placeholder="发票编号"
            :disabled="!isadd"
          />
        </el-form-item>

        <el-form-item label="发票类型" prop="invoiceType">
          <el-input v-model="form.invoiceType" placeholder="发票编号" />
        </el-form-item>

        <el-form-item label="发票税率" prop="invoiceTaxRate">
          <el-input
            v-model="form.invoiceTaxRate"
            placeholder="请输入发票税率"
          />
        </el-form-item>
        <el-form-item
          label="不含税采购单价"
          prop="purchaseUnitPriceExcludingTax"
        >
          <el-input
            v-model="form.purchaseUnitPriceExcludingTax"
            placeholder="请输入不含税采购单价"
          />
        </el-form-item>
        <el-form-item label="含税采购单价" prop="purchaseUnitPriceIncludingTax">
          <el-input
            v-model="form.purchaseUnitPriceIncludingTax"
            placeholder="请输入含税采购单价"
          />
        </el-form-item>
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
  listReceiptinvoice,
  getReceiptinvoice,
  delReceiptinvoice,
  addReceiptinvoice,
  updateReceiptinvoice,
} from "@/api/finance/receiptinvoice";

export default {
  name: "Receiptinvoice",
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
      // 入库发票信息表格数据
      receiptinvoiceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示查看窗口
      view_open: false,
      // 是否新增
      isadd: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        invoiceType: null,
        invoiceTaxRate: null,
        purchaseUnitPriceExcludingTax: null,
        purchaseUnitPriceIncludingTax: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        receiptInvoiceID: [
          { required: true, message: "入库发票编号不能为空", trigger: "blur" },
        ],
        purchaseUnitPriceExcludingTax: [
          {
            required: true,
            message: "不含税采购单价不能为空",
            trigger: "blur",
          },
        ],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询入库发票信息列表 */
    getList() {
      this.loading = true;
      listReceiptinvoice(this.queryParams).then((response) => {
        this.receiptinvoiceList = response.rows;
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
        receiptInvoiceID: null,
        invoiceType: null,
        invoiceTaxRate: null,
        purchaseUnitPriceExcludingTax: null,
        purchaseUnitPriceIncludingTax: null,
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
      this.ids = selection.map((item) => item.receiptInvoiceID);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    handleView(row) {
      this.reset();
      this.isadd = false;
      const receiptInvoiceID = row.receiptInvoiceID || this.ids;
      getReceiptinvoice(receiptInvoiceID).then((response) => {
        this.view_open = true;
        this.form = response.data;
        this.open = true;
        this.title = "查看";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.view_open = false;

      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加入库发票信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.view_open = false;
      this.reset();
      this.isadd = false;
      const receiptInvoiceID = row.receiptInvoiceID || this.ids;
      getReceiptinvoice(receiptInvoiceID).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改入库发票信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateReceiptinvoice(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReceiptinvoice(this.form).then((response) => {
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
      const receiptInvoiceIDs = row.receiptInvoiceID || this.ids;
      this.$modal
        .confirm(
          '是否确认删除入库发票信息编号为"' + receiptInvoiceIDs + '"的数据项？'
        )
        .then(function () {
          return delReceiptinvoice(receiptInvoiceIDs);
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
        "finance/receiptinvoice/export",
        {
          ...this.queryParams,
        },
        `receiptinvoice_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
