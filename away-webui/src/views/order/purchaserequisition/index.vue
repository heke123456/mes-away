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
            <el-form-item label="申购人" prop="requisitioner">
              <el-input
                v-model="queryParams.requisitioner"
                placeholder="请输入申购人"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="申购日期" prop="subscriptionDate">
              <el-date-picker
                clearable
                v-model="queryParams.subscriptionDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择申购日期"
              >
              </el-date-picker>
            </el-form-item>
            <el-form-item label="核准人" prop="approver">
              <el-input
                v-model="queryParams.approver"
                placeholder="请输入核准人"
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
                  v-for="dict in dict.type.aw_order_purchaserequisition_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                />
              </el-select>
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
          v-hasPermi="['order:purchaserequisition:add']"
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
          v-hasPermi="['order:purchaserequisition:edit']"
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
          v-hasPermi="['order:purchaserequisition:remove']"
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
          v-hasPermi="['order:purchaserequisition:export']"
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
      :data="purchaserequisitionList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="申购单编号" align="center" prop="subscribeID" />
      <el-table-column label="申购人" align="center" prop="requisitioner" />
      <el-table-column
        label="申购日期"
        align="center"
        prop="subscriptionDate"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{
            parseTime(scope.row.subscriptionDate, "{y}-{m}-{d}")
          }}</span>
        </template>
      </el-table-column>
      <el-table-column label="核准人" align="center" prop="approver" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_order_purchaserequisition_status"
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
            v-hasPermi="['order:purchaserequisition:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-s-promotion"
            v-if="scope.row.status == '0'"
            @click="handleRelease(scope.row)"
            v-hasPermi="['order:purchaserequisition:edit']"
            >发布</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            v-if="scope.row.status == '0'"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:purchaserequisition:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            v-if="scope.row.status == '0'"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:purchaserequisition:remove']"
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

    <!-- 添加或修改材料申购对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row :gutter="12"
          ><el-col :span="12"
            ><el-form-item label="申购单编号" prop="subscribeID">
              <el-input
                :disabled="!isadd"
                v-model="form.subscribeID"
                placeholder="请输入申购单编号"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="申购人" prop="requisitioner">
              <el-input
                v-model="form.requisitioner"
                placeholder="请输入申购人"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="申购日期" prop="subscriptionDate">
              <el-date-picker
                clearable
                v-model="form.subscriptionDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择申购日期"
              >
              </el-date-picker> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="核准人" prop="approver">
              <el-input
                v-model="form.approver"
                placeholder="请输入核准人"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="备注" prop="note">
              <el-input
                v-model="form.note"
                placeholder="请输入备注"
              /> </el-form-item
          ></el-col>

          <el-col :span="12">
            <el-form-item label="状态" prop="status">
              <el-select
                disabled
                v-model="form.status"
                value-key="value"
                placeholder="请选择订单状态"
              >
                <el-option
                  v-for="dict in dict.type.aw_order_purchaserequisition_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                >
                </el-option>
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
  listPurchaserequisition,
  getPurchaserequisition,
  delPurchaserequisition,
  addPurchaserequisition,
  updatePurchaserequisition,
} from "@/api/order/purchaserequisition";

export default {
  name: "Purchaserequisition",
  dicts: ["aw_order_purchaserequisition_status"],
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
      // 材料申购表格数据
      purchaserequisitionList: [],
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
        requisitioner: null,
        subscriptionDate: null,
        approver: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        subscribeID: [
          { required: true, message: "申购单编号不能为空", trigger: "blur" },
        ],
        requisitioner: [
          { required: true, message: "申购人不能为空", trigger: "blur" },
        ],
        subscriptionDate: [
          { required: true, message: "申购日期不能为空", trigger: "blur" },
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "change" },
        ],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询材料申购列表 */
    getList() {
      this.loading = true;
      listPurchaserequisition(this.queryParams).then((response) => {
        this.purchaserequisitionList = response.rows;
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
        subscribeID: null,
        requisitioner: null,
        subscriptionDate: null,
        approver: null,
        note: null,
        status: "0",
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
      this.ids = selection.map((item) => item.subscribeID);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    handleView(row) {
      let subscribeID = row.subscribeID;
      this.$router.push({
        path: "/order/detailmaterialsubscription",
        query: { subscribeID: subscribeID },
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加材料申购";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const subscribeID = row.subscribeID || this.ids;
      getPurchaserequisition(subscribeID).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改材料申购";
      });
    },
    /** 发布按钮 */
    handleRelease(row) {
      this.reset();
      this.isadd = false;
      const subscribeID = row.subscribeID || this.ids;
      getPurchaserequisition(subscribeID).then((response) => {
        this.form = response.data;
        this.form.status = "1";
        updatePurchaserequisition(this.form).then((response) => {
          this.$modal.msgSuccess("提交成功");
          this.getList();
        });
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updatePurchaserequisition(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPurchaserequisition(this.form).then((response) => {
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
      const subscribeIDs = row.subscribeID || this.ids;
      this.$modal
        .confirm('是否确认删除材料申购编号为"' + subscribeIDs + '"的数据项？')
        .then(function () {
          return delPurchaserequisition(subscribeIDs);
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
        "order/purchaserequisition/export",
        {
          ...this.queryParams,
        },
        `purchaserequisition_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
