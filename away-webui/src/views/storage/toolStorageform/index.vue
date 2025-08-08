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
      <el-form-item label="入库单编号" prop="warehouseEntryID">
        <el-input
          v-model="queryParams.warehouseEntryID"
          placeholder="请输入入库单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入库日期" prop="warehousingDate">
        <el-date-picker
          clearable
          v-model="queryParams.warehousingDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择入库日期"
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
      <el-form-item label="库房员" prop="warehouseKeeper">
        <el-input
          v-model="queryParams.warehouseKeeper"
          placeholder="请输入库房员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经办人" prop="operator">
        <el-input
          v-model="queryParams.operator"
          placeholder="请输入经办人"
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
            v-for="dict in dict.type.aw_storage_warehousing_status"
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
          v-hasPermi="['storage:toolStorageform:add']"
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
          v-hasPermi="['storage:toolStorageform:edit']"
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
          v-hasPermi="['storage:toolStorageform:remove']"
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
          v-hasPermi="['storage:toolStorageform:export']"
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
      :data="toolStorageformList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="入库单编号"
        align="center"
        prop="warehouseEntryID"
      />
      <el-table-column
        label="入库日期"
        align="center"
        prop="warehousingDate"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.warehousingDate, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="制单人" align="center" prop="creator" />
      <el-table-column label="库房员" align="center" prop="warehouseKeeper" />
      <el-table-column label="经办人" align="center" prop="operator" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_storage_warehousing_status"
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
            v-hasPermi="['storage:toolStorageform:query']"
            >查看</el-button
          >

          <el-button
            v-if="scope.row.status == '0'"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:toolStorageform:edit']"
            >修改</el-button
          >

          <el-button
            size="mini"
            type="text"
            icon="el-icon-s-promotion"
            v-if="scope.row.status == '0'"
            @click="handleRelease(scope.row)"
            v-hasPermi="['storage:toolStorageform:edit']"
            >发布</el-button
          >

          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            v-if="scope.row.status == '1'"
            @click="handleUnpublish(scope.row)"
            v-hasPermi="['storage:toolStorageform:edit']"
            >撤销发布</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            v-if="scope.row.status == '1'"
            @click="handleWarehousing(scope.row)"
            v-hasPermi="['storage:toolStorageform:edit']"
            >入库</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            v-if="scope.row.status == '2'"
            @click="handleFinish(scope.row)"
            v-hasPermi="['storage:toolStorageform:addnumber']"
            >完成入库</el-button
          >

          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            v-if="scope.row.status == '2'"
            @click="handlePause(scope.row)"
            v-hasPermi="['storage:toolStorageform:edit']"
            >暂停</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            v-if="scope.row.status == '4'"
            @click="handleCancelPause(scope.row)"
            v-hasPermi="['storage:toolStorageform:edit']"
            >取消暂停</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            v-if="scope.row.status == '4'"
            @click="handleDiscard(scope.row)"
            v-hasPermi="['storage:toolStorageform:edit']"
            >废弃</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            v-if="scope.row.status == '0'"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:toolStorageform:remove']"
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

    <!-- 添加或修改刀具入库单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="刀具入库编号" prop="warehouseEntryID">
          <el-input
            v-model="form.warehouseEntryID"
            placeholder="请输入制单人"
            :disabled="!isadd"
          />
        </el-form-item>
        <el-form-item label="入库日期" prop="warehousingDate">
          <el-date-picker
            clearable
            v-model="form.warehousingDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入库日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="制单人" prop="creator">
          <el-input v-model="form.creator" placeholder="请输入制单人" />
        </el-form-item>
        <el-form-item label="库房员" prop="warehouseKeeper">
          <el-input v-model="form.warehouseKeeper" placeholder="请输入库房员" />
        </el-form-item>
        <el-form-item label="经办人" prop="operator">
          <el-input v-model="form.operator" placeholder="请输入经办人" />
        </el-form-item>

        <el-form-item label="备注" prop="notes">
          <el-input v-model="form.notes" placeholder="备注" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择状态" disabled>
            <el-option
              v-for="dict in dict.type.aw_storage_warehousing_status"
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
  listToolStorageform,
  getToolStorageform,
  delToolStorageform,
  addToolStorageform,
  updateToolStorageform,
} from "@/api/storage/toolStorageform";
import { listDetailsOfToolStorage } from "@/api/storage/DetailsOfToolStorage";
import { addByNumber } from "@/api/storage/LocalTool.js";

export default {
  name: "ToolStorageform",
  dicts: ["aw_storage_warehousing_status"],
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
      // 刀具入库单表格数据
      toolStorageformList: [],
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
        warehouseEntryID: null,
        warehousingDate: null,
        creator: null,
        warehouseKeeper: null,
        operator: null,
        notes: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        warehouseEntryID: [
          { required: true, message: "入库单编号不能为空", trigger: "blur" },
        ],
        warehousingDate: [
          { required: true, message: "入库日期不能为空", trigger: "blur" },
        ],
        creator: [
          { required: true, message: "制单人不能为空", trigger: "blur" },
        ],
        warehouseKeeper: [
          { required: true, message: "库房员不能为空", trigger: "blur" },
        ],
        operator: [
          { required: true, message: "经办人不能为空", trigger: "blur" },
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "change" },
        ],
      },

      //刀具入库详细列表
      DetailsOfToolStoragesList: [],
      //刀具入库按钮详细
      DetailsOfToolStorages: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询刀具入库单列表 */
    getList() {
      this.loading = true;
      listToolStorageform(this.queryParams).then((response) => {
        this.toolStorageformList = response.rows;
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
        warehouseEntryID: null,
        warehousingDate: null,
        creator: null,
        warehouseKeeper: null,
        operator: null,
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
      this.ids = selection.map((item) => item.warehouseEntryID);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    handleView(row) {
      let warehouseEntryID = row.warehouseEntryID;
      this.$router.push({
        path: "DetailsOfToolStorage",
        query: { id: warehouseEntryID, status: row.status },
      });
      this.view_open = true;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加刀具入库单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const warehouseEntryID = row.warehouseEntryID || this.ids;
      getToolStorageform(warehouseEntryID).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改刀具入库单";
      });
    },
    // 状态调整
    setStatus(row, status) {
      this.reset();
      this.isadd = false;
      const warehouseEntryID = row.warehouseEntryID || this.ids;
      getToolStorageform(warehouseEntryID).then((response) => {
        this.form = response.data;
        this.form.status = status;
        updateToolStorageform(this.form).then((response) => {
          this.$modal.msgSuccess("状态变更成功");
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
    /** 暂停按钮操作 */
    handlePause(row) {
      this.setStatus(row, "4");
    },
    /** 取消暂停按钮操作 */
    handleCancelPause(row) {
      this.setStatus(row, "2");
    },
    /** 废弃按钮操作 */
    handleDiscard(row) {
      this.setStatus(row, "5");
    },
    /** 入库按钮操作 */
    handleWarehousing(row) {
      this.loading = true;
      let warehouseEntryID = row.warehouseEntryID;
      listDetailsOfToolStorage({ warehouseEntryID: warehouseEntryID }).then(
        (response) => {
          this.DetailsOfToolStorages = response.rows;
          if (this.DetailsOfToolStorages.length > 0) {
            this.setStatus(row, "2");
          } else {
            this.$modal.msgWarning("入库单中不存在！");
          }
          this.loading = false;
        }
      );
    },

    //入库完成

    async handleFinish(row) {
      let warehouseEntryID = row.warehouseEntryID;
      this.loading = true;

      let total = await listDetailsOfToolStorage()["total"];

      listDetailsOfToolStorage({
        pageSize: total,
        warehouseEntryID: warehouseEntryID,
      }).then((response) => {
        this.DetailsOfToolStoragesList = response.rows;
        if (this.DetailsOfToolStoragesList.length > 0) {
          let lmlist = [];
          for (let num in this.DetailsOfToolStoragesList) {
            let toolInformationID =
              this.DetailsOfToolStoragesList[num].toolInformationID;
            let value = this.DetailsOfToolStoragesList[num].receiptQuantity;
            lmlist.push({ key: toolInformationID, value: value });
          }
          addByNumber(JSON.stringify(lmlist)).then((response) => {
            if (response.code == "200") {
              this.setStatus(row, "3");
            }
          });
        }
        this.loading = false;
      });
    },
    //

    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateToolStorageform(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addToolStorageform(this.form).then((response) => {
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
      const warehouseEntryIDs = row.warehouseEntryID || this.ids;
      this.$modal
        .confirm(
          '是否确认删除刀具入库单编号为"' + warehouseEntryIDs + '"的数据项？'
        )
        .then(function () {
          return delToolStorageform(warehouseEntryIDs);
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
        "storage/toolStorageform/export",
        {
          ...this.queryParams,
        },
        `toolStorageform_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
