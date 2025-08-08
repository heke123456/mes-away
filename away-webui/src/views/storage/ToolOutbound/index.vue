<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
    <el-row :gutter="1">
            <el-col :span="21">
              <div style="overflow-x: auto;scrollbar-width: none; white-space: nowrap;">
      <el-form-item label="出库单编号" prop="deliveryNoteID">
        <el-input
          v-model="queryParams.deliveryNoteID"
          placeholder="请输入出库单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="刀具基本信息编号" prop="toolInformationID">
        <el-input
          v-model="queryParams.toolInformationID"
          placeholder="请输入刀具基本信息编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出库数量" prop="outboundQuantity">
        <el-input
          v-model="queryParams.outboundQuantity"
          placeholder="请输入出库数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="新旧类型" prop="newAndOldTypes">
        <el-select v-model="queryParams.newAndOldTypes" placeholder="请选择新旧类型" clearable>
          <el-option
            v-for="dict in dict.type.aw_storage_tooloutbound_newandoldtypes"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="领用用途" prop="materialRequisition">
        <el-select v-model="queryParams.materialRequisition" placeholder="请选择领用用途" clearable>
          <el-option
            v-for="dict in dict.type.aw_storage_tooloutbound_materialrequisition"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="备注" prop="notes">
        <el-input
          v-model="queryParams.notes"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
 </div>
        </el-col>
        <el-col :span="3">
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
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
          v-hasPermi="['storage:ToolOutbound:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['storage:ToolOutbound:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['storage:ToolOutbound:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['storage:ToolOutbound:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ToolOutboundList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="刀具出库id" align="center" prop="id" />
      <el-table-column label="出库单编号" align="center" prop="deliveryNoteID" />
      <el-table-column label="刀具基本信息编号" align="center" prop="toolInformationID" />
      <el-table-column label="出库数量" align="center" prop="outboundQuantity" />
      <el-table-column label="新旧类型" align="center" prop="newAndOldTypes">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.aw_storage_tooloutbound_newandoldtypes" :value="scope.row.newAndOldTypes"/>
        </template>
      </el-table-column>
      <el-table-column label="领用用途" align="center" prop="materialRequisition">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.aw_storage_tooloutbound_materialrequisition" :value="scope.row.materialRequisition"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="notes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
        <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['storage:ToolOutbound:query']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:ToolOutbound:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:ToolOutbound:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改刀具出库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="出库单编号" prop="deliveryNoteID">
          <el-input v-model="form.deliveryNoteID" placeholder="请输入出库单编号" />
        </el-form-item>
        <el-form-item label="刀具基本信息编号" prop="toolInformationID">
          <el-input v-model="form.toolInformationID" placeholder="请输入刀具基本信息编号" />
        </el-form-item>
        <el-form-item label="出库数量" prop="outboundQuantity">
          <el-input v-model="form.outboundQuantity" placeholder="请输入出库数量" />
        </el-form-item>
        <el-form-item label="新旧类型" prop="newAndOldTypes">
          <el-radio-group v-model="form.newAndOldTypes">
            <el-radio
              v-for="dict in dict.type.aw_storage_tooloutbound_newandoldtypes"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="领用用途" prop="materialRequisition">
          <el-radio-group v-model="form.materialRequisition">
            <el-radio
              v-for="dict in dict.type.aw_storage_tooloutbound_materialrequisition"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入备注" />
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
import { listToolOutbound, getToolOutbound, delToolOutbound, addToolOutbound, updateToolOutbound } from "@/api/storage/ToolOutbound";

export default {
  name: "ToolOutbound",
  dicts: ['aw_storage_tooloutbound_materialrequisition', 'aw_storage_tooloutbound_newandoldtypes'],
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
      // 刀具出库表格数据
      ToolOutboundList: [],
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
        deliveryNoteID: null,
        toolInformationID: null,
        outboundQuantity: null,
        newAndOldTypes: null,
        materialRequisition: null,
        notes: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        deliveryNoteID: [
          { required: true, message: "出库单编号不能为空", trigger: "blur" }
        ],
        toolInformationID: [
          { required: true, message: "刀具基本信息编号不能为空", trigger: "blur" }
        ],
        outboundQuantity: [
          { required: true, message: "出库数量不能为空", trigger: "blur" }
        ],
        newAndOldTypes: [
          { required: true, message: "新旧类型不能为空", trigger: "change" }
        ],
        materialRequisition: [
          { required: true, message: "领用用途不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询刀具出库列表 */
    getList() {
      this.loading = true;
      listToolOutbound(this.queryParams).then(response => {
        this.ToolOutboundList = response.rows;
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
        deliveryNoteID: null,
        toolInformationID: null,
        outboundQuantity: null,
        newAndOldTypes: null,
        materialRequisition: null,
        notes: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    handleView(row) {
      this.view_open = true;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加刀具出库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids
      getToolOutbound(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改刀具出库";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (!this.isadd) {
            updateToolOutbound(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addToolOutbound(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除刀具出库编号为"' + ids + '"的数据项？').then(function() {
        return delToolOutbound(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('storage/ToolOutbound/export', {
        ...this.queryParams
      }, `ToolOutbound_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
