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
      <el-form-item label="客户姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入客户姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品名称" prop="productName">
        <el-input
          v-model="queryParams.productName"
          placeholder="请输入产品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="应付金额" prop="amountDue">
        <el-input
          v-model="queryParams.amountDue"
          placeholder="请输入应付金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="实付金额" prop="outOfPocketAmount">
        <el-input
          v-model="queryParams.outOfPocketAmount"
          placeholder="请输入实付金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="未付金额" prop="unpaidAmount">
        <el-input
          v-model="queryParams.unpaidAmount"
          placeholder="请输入未付金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="备注" prop="notes">
        <el-input
          v-model="queryParams.notes"
          placeholder="请输入产品名称"
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
          v-hasPermi="['finance:DetailReconciliation:add']"
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
          v-hasPermi="['finance:DetailReconciliation:edit']"
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
          v-hasPermi="['finance:DetailReconciliation:remove']"
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
          v-hasPermi="['finance:DetailReconciliation:export']"
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
      :data="DetailReconciliationList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="对账单Id"
        align="center"
        prop="statementOfAccountID"
      />
      <el-table-column label="订单id" align="center" prop="saleorderID" />
      <el-table-column label="合同金额" align="center" prop="money" />
      <el-table-column label="客户姓名" align="center" prop="name" />
      <el-table-column label="产品名称" align="center" prop="productName" />
      <el-table-column label="客户需求量" align="center" prop="number" />
      <el-table-column
        label="已供产品量"
        align="center"
        prop="numberOfProductsSupplied"
      />
      <el-table-column label="应付金额" align="center" prop="orderAmount" />
      <el-table-column label="应付金额" align="center" prop="amountDue" />
      <el-table-column
        label="实付金额"
        align="center"
        prop="outOfPocketAmount"
      />
      <el-table-column label="未付金额" align="center" prop="unpaidAmount" />
      <el-table-column label="是否通过" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_finance_reconciliation"
            :value="scope.row.status"
          />
        </template>
      </el-table-column>
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
            v-hasPermi="['finance:DetailReconciliation:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['finance:DetailReconciliation:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['finance:DetailReconciliation:remove']"
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

    <!-- 添加或修改对账详细对话框 -->
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
            <el-form-item label="对账单编号" prop="statementOfAccountID">
              <el-input
                disabled
                v-model="form.statementOfAccountID"
                placeholder="请输入对账单编号"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="订单信息" prop="saleorderID">
              <el-select
                filterable
                v-model="form.saleorderID"
                placeholder="请选择需要对账的订单"
                @focus="getSaleorderList()"
              >
                <el-option
                  v-for="(item, index) in BasicOrderInformationList"
                  :key="index"
                  :label="item.id"
                  :value="item.id"
                  @click.native="setSaleorderList(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="客户姓名" prop="name">
              <el-input
                disabled
                v-model="BasicOrderInformation.name"
                placeholder="请输入客户姓名"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="合同金额" prop="money">
              <el-input
                disabled
                v-model="BasicOrderInformation.money"
                placeholder="请输入合同金额"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="产品名称" prop="productName">
              <el-input
                disabled
                v-model="BasicOrderInformation.productName"
                placeholder="请输入产品名称"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="客户需求量" prop="number">
              <el-input
                disabled
                v-model="BasicOrderInformation.number"
                placeholder="请输入客户需求量"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="已供产品量" prop="numberOfProductsSupplied">
              <el-input
                v-model="form.numberOfProductsSupplied"
                placeholder="请输入已供产品数量"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="订单金额" prop="orderAmount">
              <el-input
                v-model="form.orderAmount"
                placeholder="请输入订单金额"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="应付金额" prop="amountDue">
              <el-input v-model="form.amountDue" placeholder="请输入应付金额" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="实付金额" prop="outOfPocketAmount">
              <el-input
                v-model="form.outOfPocketAmount"
                placeholder="请输入实付金额"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="未付金额" prop="unpaidAmount">
              <el-input
                v-model="form.unpaidAmount"
                placeholder="请输入未付金额"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="状态" prop="status">
              <el-select v-model="form.status" placeholder="请选择状态">
                <el-option
                  v-for="dict in dict.type.aw_finance_reconciliation"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="客户价格" prop="customerPrice">
              <el-input
                v-model="form.customerPrice"
                placeholder="请输入客户价格"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发票价格" prop="invoicePrice">
              <el-input
                v-model="form.invoicePrice"
                placeholder="请输入发票价格"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="工艺价格" prop="processPrice">
              <el-input
                v-model="form.processPrice"
                placeholder="请输入工艺价格"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="备注" prop="notes">
              <el-input v-model="form.notes" placeholder="请输入备注" />
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
  listDetailReconciliation,
  getDetailReconciliation,
} from "@/api/finance/DetailReconciliation";

import {
  delReconciliation,
  addReconciliation,
  updateReconciliation,
} from "@/api/finance/Reconciliation";
import {
  listBasicOrderInformation,
  getBasicOrderInformation,
} from "@/api/order/BasicOrderInformation";

export default {
  name: "DetailReconciliation",
  dicts: ["aw_finance_reconciliation"],
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
      // 对账详细表格数据
      DetailReconciliationList: [],
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
        statementOfAccountID: null,
        name: null,
        productName: null,
        orderAmount: null,
        amountDue: null,
        outOfPocketAmount: null,
        unpaidAmount: null,
        notes: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [{ required: true, message: "对账id不能为空", trigger: "blur" }],
        statementOfAccountID: [
          { required: true, message: "对账单不能为空", trigger: "blur" },
        ],
        saleorderID: [
          { required: true, message: "订单id不能为空", trigger: "blur" },
        ],
        status: [
          { required: true, message: "订单id不能为空", trigger: "blur" },
        ],
      },
      //当前对账单id
      statementOfAccountID: "",

      //订单列表
      BasicOrderInformationList: [],
      //选中的订单：
      BasicOrderInformation: {},
    };
  },
  created() {
    this.getExist();
    this.loading = false;
  },
  methods: {
    /** 查询对账详细列表 */

    getExist() {
      this.statementOfAccountID = this.$route.query.id;
      this.queryParams.statementOfAccountID = this.statementOfAccountID;
      this.getList();
    },
    getList() {
      console.log();
      this.loading = true;
      listDetailReconciliation(this.queryParams).then((response) => {
        this.DetailReconciliationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    //查询订单列表

    async getSaleorderList() {
      this.loading = true;
      let total = (await listBasicOrderInformation())["total"];
      listBasicOrderInformation({ pageSize: total }).then((response) => {
        this.BasicOrderInformationList = response.rows;
        this.loading = false;
      });
    },

    setSaleorderList(id) {
      console.log(id);
      this.loading = true;
      getBasicOrderInformation(id).then((response) => {
        this.BasicOrderInformation = response.data;
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
        statementOfAccountID: this.$route.query.id,
        saleorderID: null,
        money: null,
        name: null,
        productName: null,
        number: null,
        numberOfProductsSupplied: null,
        orderAmount: null,
        amountDue: null,
        outOfPocketAmount: null,
        unpaidAmount: null,
        customerPrice: null,
        invoicePrice: null,
        processPrice: null,
        notes: null,
        status: null,
      };
      (this.BasicOrderInformationList = []), (this.BasicOrderInformation = {});

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
    //查看对账详细
    handleView(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getDetailReconciliation(id).then((response) => {
        this.form = response.data;
        this.open = true;
        getBasicOrderInformation(row.saleorderID).then((response) => {
          this.BasicOrderInformation = response.data;
          this.loading = false;
        });
        this.title = "查看对账详细";
        this.view_open = true;
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.view_open = false;
      this.isadd = true;
      this.open = true;
      this.title = "添加对账详细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.loading = true;
      this.view_open = false;
      this.isadd = false;
      const id = row.id || this.ids;
      getDetailReconciliation(id).then((response) => {
        this.form = response.data;
        getBasicOrderInformation(row.saleorderID).then((response) => {
          this.BasicOrderInformation = response.data;
          this.loading = false;
        });
        this.open = true;
        this.title = "修改对账详细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateReconciliation(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReconciliation(this.form).then((response) => {
              console.log(this.form);
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
        .confirm('是否确认删除对账详细编号为"' + ids + '"的数据项？')
        .then(function () {
          return delReconciliation(ids);
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
        "finance/DetailReconciliation/export",
        {
          ...this.queryParams,
        },
        `DetailReconciliation_${new Date().getTime()}.xlsx`
      );
    },
  },

  watch: {
    "$route.query.id": {
      immediate: true,
      handler() {
        this.getExist();
      },
    },
  },
};
</script>
