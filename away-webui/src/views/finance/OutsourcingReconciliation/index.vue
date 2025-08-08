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
      <el-form-item label="外协完成数量" prop="completedQuantity">
        <el-input
          v-model="queryParams.completedQuantity"
          placeholder="请输入外协完成数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="未完成数量" prop="unfinishedQuantity">
        <el-input
          v-model="queryParams.unfinishedQuantity"
          placeholder="请输入未完成数量"
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
      <el-form-item label="客户价格" prop="customerPrice">
        <el-input
          v-model="queryParams.customerPrice"
          placeholder="请输入客户价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发票价格" prop="invoicePrice">
        <el-input
          v-model="queryParams.invoicePrice"
          placeholder="请输入发票价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="外协价格" prop="outsourcingPrice">
        <el-input
          v-model="queryParams.outsourcingPrice"
          placeholder="请输入外协价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工艺价格" prop="processPrice">
        <el-input
          v-model="queryParams.processPrice"
          placeholder="请输入工艺价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="notes">
        <el-input
          v-model="queryParams.notes"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="状态" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="请选择状态"
          clearable
        >
          <el-option
            v-for="dict in dict.type.aw_finance_reconciliation"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['finance:OutsourcingReconciliation:add']"
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
          v-hasPermi="['finance:OutsourcingReconciliation:edit']"
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
          v-hasPermi="['finance:OutsourcingReconciliation:remove']"
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
          v-hasPermi="['finance:OutsourcingReconciliation:export']"
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
      :data="OutsourcingReconciliationList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="外协对账d" align="center" prop="id" />
      <el-table-column
        label="外协对账单编号"
        align="center"
        prop="outsourcingStatementsID"
      />
      <el-table-column
        label="外协订单id"
        align="center"
        prop="outsourcingOrderID"
      />
      <el-table-column
        label="外协数量"
        align="center"
        prop="outsourcingQuantity"
      />
      <el-table-column
        label="外协完成数量"
        align="center"
        prop="completedQuantity"
      />
      <el-table-column
        label="未完成数量"
        align="center"
        prop="unfinishedQuantity"
      />
      <el-table-column label="订单金额" align="center" prop="orderAmount" />

      <el-table-column
        label="实付金额"
        align="center"
        prop="outOfPocketAmount"
      />
      <el-table-column label="未付金额" align="center" prop="unpaidAmount" />
      <el-table-column label="客户价格" align="center" prop="customerPrice" />
      <el-table-column label="发票价格" align="center" prop="invoicePrice" />
      <el-table-column
        label="外协价格"
        align="center"
        prop="outsourcingPrice"
      />
      <el-table-column label="工艺价格" align="center" prop="processPrice" />

      <el-table-column label="状态" align="center" prop="status">
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
            v-hasPermi="['finance:OutsourcingReconciliation:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['finance:OutsourcingReconciliation:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['finance:OutsourcingReconciliation:remove']"
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
            <el-form-item label="外协对账单编号" prop="outsourcingStatementsID">
              <el-input
                disabled
                v-model="this.outsourcingStatementsID"
                placeholder="请输入外协对账单编号"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="外协订单id" prop="outsourcingOrderID">
              <el-select
                filterable
                v-model="form.outsourcingOrderID"
                placeholder="请输入外协订单id"
                @focus="getoutsourcingOrderList()"
              >
                <el-option
                  v-for="(item, index) in outsourcingOrderList"
                  :key="index"
                  :label="item.outsourcingOrderID"
                  :value="item.outsourcingOrderID"
                  @click.native="
                    setoutsourcingOrderList(item.outsourcingOrderID)
                  "
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="委外类型" prop="outsourcingType">
              <el-select
                disabled
                v-model="outsourcingOrder.outsourcingType"
                placeholder="请选择委外类型"
              >
                <el-option
                  v-for="dict in dict.type.aw_order_outsourcingorder_type"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
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
            <el-form-item label="外协数量" prop="outsourcingQuantity">
              <el-input
                v-model="form.outsourcingQuantity"
                placeholder="请输入外协数量"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="外协完成数量" prop="completedQuantity">
              <el-input
                v-model="form.completedQuantity"
                placeholder="请输入外协完成数量"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="未完成数量" prop="unfinishedQuantity">
              <el-input
                v-model="form.unfinishedQuantity"
                placeholder="请输入未完成数量"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="应付金额" prop="amountDue">
              <el-input v-model="form.amountDue" placeholder="请输入应付金额" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="实付金额" prop="outOfPocketAmount">
              <el-input
                v-model="form.outOfPocketAmount"
                placeholder="请输入实付金额"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="未付金额" prop="unpaidAmount">
              <el-input
                v-model="form.unpaidAmount"
                placeholder="请输入未付金额"
              />
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
            <el-form-item label="外协价格" prop="outsourcingPrice">
              <el-input
                v-model="form.outsourcingPrice"
                placeholder="请输入外协价格"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="备注" prop="notes">
              <el-input v-model="form.notes" placeholder="请输入备注" />
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
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listOutsourcingReconciliation,
  getOutsourcingReconciliation,
  delOutsourcingReconciliation,
  addOutsourcingReconciliation,
  updateOutsourcingReconciliation,
} from "@/api/finance/OutsourcingReconciliation";
import {
  listOutsourcingorder,
  getOutsourcingorder,
} from "@/api/order/outsourcingorder";
export default {
  name: "OutsourcingReconciliation",
  dicts: ["aw_finance_reconciliation", "aw_order_outsourcingorder_type"],
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
      // 外协对账表格数据
      OutsourcingReconciliationList: [],
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
        outsourcingStatementsID: null,
        outsourcingOrderID: null,
        outsourcingQuantity: null,
        completedQuantity: null,
        unfinishedQuantity: null,
        orderAmount: null,
        amountDue: null,
        outOfPocketAmount: null,
        unpaidAmount: null,
        notes: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        outsourcingStatementsID: [
          {
            required: true,
            message: "外协对账单编号不能为空",
            trigger: "blur",
          },
        ],
        outsourcingOrderID: [
          { required: true, message: "外协订单id不能为空", trigger: "blur" },
        ],

        status: [
          { required: true, message: "状态不能为空", trigger: "change" },
        ],
      },
      // 父单id
      outsourcingStatementsID: "",
      //外协订单列表
      outsourcingOrderList: [],
      //选中外协订单
      outsourcingOrder: {},
    };
  },
  created() {
    this.getExist();
  },

  methods: {
    /** 查询外协对账列表 */

    getList() {
      this.loading = true;
      listOutsourcingReconciliation(this.queryParams).then((response) => {
        this.OutsourcingReconciliationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    getExist() {
      this.outsourcingStatementsID = this.$route.query.id;
      this.queryParams.outsourcingStatementsID = this.outsourcingStatementsID;
      this.getList();
    },
    //获取外协订单列表
    async getoutsourcingOrderList() {
      this.loading = true;
      let total = (await listOutsourcingorder())["total"];
      listOutsourcingorder({ pageSize: total }).then((response) => {
        this.outsourcingOrderList = response.rows;
        this.loading = false;
      });
    },

    //选中外协订单列表
    setoutsourcingOrderList(id) {
      this.loading = true;
      getOutsourcingorder(id).then((response) => {
        this.outsourcingOrder = response.data;
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
        outsourcingStatementsID: this.$route.query.id,
        outsourcingOrderID: null,
        outsourcingQuantity: null,
        completedQuantity: null,
        unfinishedQuantity: null,
        orderAmount: null,
        amountDue: null,
        outOfPocketAmount: null,
        unpaidAmount: null,
        notes: null,
        status: null,
      };

      (this.outsourcingOrderList = []),
        (this.outsourcingOrder = {}),
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
      this.view_open = true;
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getOutsourcingReconciliation(id).then((response) => {
        this.form = response.data;
        this.open = true;
        getOutsourcingorder(row.outsourcingOrderID).then((response) => {
          this.outsourcingOrder = response.data;
        });
        this.title = "修改外协对账";
      });
    },

    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.view_open = false;
      this.isadd = true;
      this.open = true;
      this.title = "添加外协对账";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.view_open = false;
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getOutsourcingReconciliation(id).then((response) => {
        this.form = response.data;
        this.open = true;
        getOutsourcingorder(row.outsourcingOrderID).then((response) => {
          this.outsourcingOrder = response.data;
        });
        this.title = "修改外协对账";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateOutsourcingReconciliation(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOutsourcingReconciliation(this.form).then((response) => {
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
        .confirm('是否确认删除外协对账编号为"' + ids + '"的数据项？')
        .then(function () {
          return delOutsourcingReconciliation(ids);
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
        "finance/OutsourcingReconciliation/export",
        {
          ...this.queryParams,
        },
        `OutsourcingReconciliation_${new Date().getTime()}.xlsx`
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
