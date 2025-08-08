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
            <el-form-item label="材料基本名称" prop="name">
              <el-input
                v-model="queryParams.name"
                placeholder="请输入材料名称"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="材料库存数量" prop="number">
              <el-input
                v-model="queryParams.number"
                placeholder="请输入材料库存数量"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="材料库存重量" prop="weight">
              <el-input
                v-model="queryParams.weight"
                placeholder="请输入材料库存重量"
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
          v-hasPermi="['storage:localmaterials:add']"
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
          v-hasPermi="['storage:localmaterials:edit']"
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
          v-hasPermi="['storage:localmaterials:remove']"
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
          v-hasPermi="['storage:localmaterials:export']"
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
      :data="localmaterialsList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="材料库存id" align="center" prop="id" />
      <el-table-column label="材料名称" align="center" prop="name" />
      <el-table-column label="材料价格" align="center" prop="notes" />
      <el-table-column label="材料库存数量" align="center" prop="number" />
      <el-table-column label="材料库存重量" align="center" prop="weight" />
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
            v-hasPermi="['storage:localmaterials:query']"
            >查看</el-button
          >

          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:localmaterials:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:localmaterials:remove']"
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

    <!-- 添加或修改本地材料实时库存对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        :disabled="view_open"
      >
        <el-form-item label="材料基本信息" prop="material">
          <el-select
            v-model="form.materialID"
            @focus="getListMaterial()"
            placeholder="请选择材料基本信息"
          >
            <el-option
              @click.native="setMaterial(item.id)"
              v-for="item in materials_info"
              :key="item.id"
              :label="item.id"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="材料名称">
          <el-input
            v-model="materials.name"
            disabled
            placeholder="请输入材料名称"
          />
        </el-form-item>

        <el-form-item label="材料价格">
          <el-input
            v-model="materials.notes"
            disabled
            placeholder="请输入材料价格"
          />
        </el-form-item>

        <el-form-item label="材料库存数量" prop="number">
          <el-input v-model="form.number" placeholder="请输入材料库存数量" />
        </el-form-item>
        <el-form-item label="材料库存重量" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入材料库存重量" />
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
  listLocalmaterials,
  getLocalmaterials,
  delLocalmaterials,
  addLocalmaterials,
  updateLocalmaterials,
} from "@/api/storage/localmaterials";
import { listMaterial, getMaterial } from "@/api/storage/material";

export default {
  name: "Localmaterials",
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
      // 本地材料实时库存表格数据
      localmaterialsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      view_open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
      },
      // 材料基本信息
      materials_info: [],
      materials: {},
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        materialID: [
          {
            required: true,
            message: "材料基本信息id不能为空",
            trigger: "blur",
          },
        ],
        number: [
          { required: true, message: "材料库存数量不能为空", trigger: "blur" },
        ],
        weight: [
          { required: true, message: "材料库存重量不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询本地材料实时库存列表 */
    getList() {
      this.loading = true;
      listLocalmaterials(this.queryParams).then((response) => {
        this.localmaterialsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询材料基本信息*/
    getListMaterial() {
      listMaterial({}).then((respoense) => {
        this.materials_info = respoense.rows;
      });
    },
    setMaterial(id) {
      getMaterial(id).then((respoense) => {
        this.materials = respoense.data;
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
        materialID: null,
        number: null,
        weight: null,
      };
      this.materials_info = [];
      this.materials = {};
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
    /** 新增按钮操作 */
    handleAdd() {
      this.view_open = false;

      this.reset();
      this.getListMaterial();
      this.open = true;
      this.title = "添加本地材料实时库存";
    },

    handleView(row) {
      this.reset();
      this.view_open = true;
      this.getListMaterial();
      const id = row.id || this.ids;
      getLocalmaterials(id).then((response) => {
        getMaterial(row.materialID).then((response) => {
          this.materials = response.data;
          console.log(response.data);
        });
        this.form = response.data;
        this.open = true;
        this.title = "查看本地材料实时库存";
      });
    },

    /** 修改按钮操作 */
    handleUpdate(row) {
      this.view_open = false;

      this.reset();
      this.getListMaterial();
      const id = row.id || this.ids;
      getLocalmaterials(id).then((response) => {
        getMaterial(row.materialID).then((response) => {
          this.materials = response.data;
          console.log(response.data);
        });
        this.form = response.data;
        this.open = true;
        this.title = "修改本地材料实时库存";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateLocalmaterials(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLocalmaterials(this.form).then((response) => {
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
        .confirm('是否确认删除本地材料实时库存编号为"' + ids + '"的数据项？')
        .then(function () {
          return delLocalmaterials(ids);
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
        "storage/localmaterials/export",
        {
          ...this.queryParams,
        },
        `localmaterials_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
