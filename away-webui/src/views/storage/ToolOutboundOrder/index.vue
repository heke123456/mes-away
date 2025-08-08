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
      <el-form-item label="出库日期" prop="deliveryDate">
        <el-date-picker
          clearable
          v-model="queryParams.deliveryDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出库日期"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="制单人" prop="creator">
        <el-input
          v-model="queryParams.creator"
          placeholder="请输入制单人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发料人" prop="issuedBy">
        <el-input
          v-model="queryParams.issuedBy"
          placeholder="请输入发料人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="领料人" prop="materialReceiver">
        <el-input
          v-model="queryParams.materialReceiver"
          placeholder="请输入领料人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批人" prop="approver">
        <el-input
          v-model="queryParams.approver"
          placeholder="请输入审批人"
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
            v-for="dict in dict.type.aw_storage_outboundorder_status"
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
          v-hasPermi="['storage:ToolOutboundOrder:add']"
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
          v-hasPermi="['storage:ToolOutboundOrder:edit']"
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
          v-hasPermi="['storage:ToolOutboundOrder:remove']"
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
          v-hasPermi="['storage:ToolOutboundOrder:export']"
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
      :data="ToolOutboundOrderList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="出库单编号"
        align="center"
        prop="deliveryNoteID"
      />
      <el-table-column
        label="出库日期"
        align="center"
        prop="deliveryDate"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deliveryDate, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="制单人" align="center" prop="creator" />
      <el-table-column label="发料人" align="center" prop="issuedBy" />
      <el-table-column label="领料人" align="center" prop="materialReceiver" />
      <el-table-column label="审批人" align="center" prop="approver" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_storage_outboundorder_status"
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
            v-hasPermi="['storage:ToolOutboundOrder:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-if="scope.row.status == '0'"
            v-hasPermi="['storage:ToolOutboundOrder:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-if="scope.row.status == '0'"
            v-hasPermi="['storage:ToolOutboundOrder:remove']"
            >删除</el-button
          >

          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleRelease(scope.row)"
            v-if="scope.row.status == '0'"
            v-hasPermi="['storage:ToolOutboundOrder:edit']"
            >发布</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleUnpublish(scope.row)"
            v-if="scope.row.status == '1'"
            v-hasPermi="['storage:ToolOutboundOrder:edit']"
            >撤销发布</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleFinish(scope.row)"
            v-if="scope.row.status == '1'"
            v-hasPermi="['storage:ToolOutboundOrder:reducenumber']"
            >完成出库</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handlePause(scope.row)"
            v-if="scope.row.status == '1'"
            v-hasPermi="['storage:ToolOutboundOrder:edit']"
            >暂停</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleCancelPause(scope.row)"
            v-if="scope.row.status == '3'"
            v-hasPermi="['storage:ToolOutboundOrder:edit']"
            >取消暂停</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleDiscard(scope.row)"
            v-if="scope.row.status == '3'"
            v-hasPermi="['storage:ToolOutboundOrder:edit']"
            >废弃</el-button
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

    <!-- 添加或修改刀具出库单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="刀具出库编号" prop="deliveryNoteID">
          <el-input
            :disabled="!isadd"
            v-model="form.deliveryNoteID"
            placeholder="请输入刀具出库编号"
          />
        </el-form-item>
        <el-form-item label="出库日期" prop="deliveryDate">
          <el-date-picker
            clearable
            v-model="form.deliveryDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出库日期"
          >
          </el-date-picker>
        </el-form-item>

        <el-form-item label="制单人" prop="creator">
          <el-input v-model="form.creator" placeholder="请输入制单人" />
        </el-form-item>
        <el-form-item label="发料人" prop="issuedBy">
          <el-input v-model="form.issuedBy" placeholder="请输入发料人" />
        </el-form-item>
        <el-form-item label="领料人" prop="materialReceiver">
          <el-input
            v-model="form.materialReceiver"
            placeholder="请输入领料人"
          />
        </el-form-item>
        <el-form-item label="审批人" prop="approver">
          <el-input v-model="form.approver" placeholder="请输入审批人" />
        </el-form-item>
        <el-form-item label="备注" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择状态" disabled>
            <el-option
              v-for="dict in dict.type.aw_storage_outboundorder_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
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
  listToolOutboundOrder,
  getToolOutboundOrder,
  delToolOutboundOrder,
  addToolOutboundOrder,
  updateToolOutboundOrder,
} from "@/api/storage/ToolOutboundOrder";

import { listDetailsOfToolDelivery } from "@/api/storage/DetailsOfToolDelivery";
import { reduceByNumber } from "@/api/storage/LocalTool.js";
export default {
  name: "ToolOutboundOrder",
  dicts: ["aw_storage_outboundorder_status"],
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
      // 刀具出库单表格数据
      ToolOutboundOrderList: [],
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
        deliveryDate: null,
        creator: null,
        issuedBy: null,
        materialReceiver: null,
        approver: null,
        notes: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        deliveryNoteID: [
          { required: true, message: "刀具出库编号不能为空", trigger: "blur" },
        ],
        deliveryDate: [
          { required: true, message: "出库日期不能为空", trigger: "blur" },
        ],
        creator: [
          { required: true, message: "制单人不能为空", trigger: "blur" },
        ],
        issuedBy: [
          { required: true, message: "发料人不能为空", trigger: "blur" },
        ],
        materialReceiver: [
          { required: true, message: "领料人不能为空", trigger: "blur" },
        ],
        approver: [
          { required: true, message: "审批人不能为空", trigger: "blur" },
        ],

        status: [
          { required: true, message: "状态不能为空", trigger: "change" },
        ],
      },
      //出库单详细列表
      DetailsOfToolDeliveryList: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询刀具出库单列表 */
    getList() {
      this.loading = true;
      listToolOutboundOrder(this.queryParams).then((response) => {
        this.ToolOutboundOrderList = response.rows;
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
        deliveryNoteID: null,
        deliveryDate: null,
        creator: null,
        issuedBy: null,
        materialReceiver: null,
        approver: null,
        notes: null,
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
      this.ids = selection.map((item) => item.deliveryNoteID);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加刀具出库单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const deliveryNoteID = row.deliveryNoteID || this.ids;
      getToolOutboundOrder(deliveryNoteID).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改刀具出库单";
      });
    },
    /** 状态调整 */
    setStatus(row, status) {
      this.reset();
      this.loading = true;
      const deliveryNoteID = row.deliveryNoteID || this.ids;
      getToolOutboundOrder(deliveryNoteID).then((response) => {
        this.form = response.data;
        this.form.status = status;
        updateToolOutboundOrder(this.form).then((response) => {
          this.$modal.msgSuccess("状态变更成功");
          this.open = false;
          this.getList();
          this.loading = false;
        });
      });
    },
    /** 发布按钮操作 */
    handleRelease(row) {
      this.setStatus(row, "1");
    },
    /** 撤销发布按钮操作 */
    handleUnpublish(row) {
      this.setStatus(row, "0");
    },

    /** 完成出库按钮操作 */
    async handleFinish(row) {
      let deliveryNoteID = row.deliveryNoteID;
      this.loading = true;

      let total = await listDetailsOfToolDelivery()["total"];

      // 出库刀具列表
      listDetailsOfToolDelivery({
        pageSize: total,
        deliveryNoteID: deliveryNoteID,
      }).then((response) => {
        this.DetailsOfToolDeliveryList = response.rows;
        if (this.DetailsOfToolDeliveryList.length > 0) {
          let lmlist = [];
          for (let num in this.DetailsOfToolDeliveryList) {
            let toolInformationID =
              this.DetailsOfToolDeliveryList[num].toolInformationID;
            let value = this.DetailsOfToolDeliveryList[num].outboundQuantity;
            lmlist.push({ key: toolInformationID, value: value });
          }
          reduceByNumber(JSON.stringify(lmlist)).then((response) => {
            if (response.code == "200") {
              this.setStatus(row, "2");
            }
          });
        } else {
          this.$modal.msgWarning("刀具出库单中不存在刀具");
        }
        this.loading = false;
      });
    },

    /** 暂停按钮操作 */
    handlePause(row) {
      this.setStatus(row, "3");
    },
    /** 取消暂停按钮操作 */
    handleCancelPause(row) {
      this.setStatus(row, "1");
    },
    /** 废弃按钮操作 */
    handleDiscard(row) {
      this.setStatus(row, "4");
    },
    handleView(row) {
      this.view_open = true;
      this.$router.push({
        path: "DetailsOfToolDelivery",
        query: { id: row.deliveryNoteID, status: row.status },
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加刀具出库单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const deliveryNoteID = row.deliveryNoteID || this.ids;
      getToolOutboundOrder(deliveryNoteID).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改刀具出库单";
      });
    },

    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateToolOutboundOrder(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addToolOutboundOrder(this.form).then((response) => {
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
      const deliveryNoteIDs = row.deliveryNoteID || this.ids;
      this.$modal
        .confirm(
          '是否确认删除刀具出库单编号为"' + deliveryNoteIDs + '"的数据项？'
        )
        .then(function () {
          return delToolOutboundOrder(deliveryNoteIDs);
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
        "storage/ToolOutboundOrder/export",
        {
          ...this.queryParams,
        },
        `ToolOutboundOrder_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
