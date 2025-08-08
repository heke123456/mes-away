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
            <el-form-item label="材料名称" prop="name">
              <el-input
                v-model="queryParams.name"
                placeholder="请输入材料名称"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="规格型号" prop="specificationModel">
              <el-input
                v-model="queryParams.specificationModel"
                placeholder="请输入规格型号"
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
          v-hasPermi="['produce:MaterialListOfTechnology:add']"
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
          v-hasPermi="['produce:MaterialListOfTechnology:edit']"
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
          v-hasPermi="['produce:MaterialListOfTechnology:remove']"
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
          v-hasPermi="['produce:MaterialListOfTechnology:export']"
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
      :data="MaterialListOfTechnologyList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="材料名称" align="center" prop="name" />
      <el-table-column label="材料密度" align="center" prop="materialDensity" />
      <el-table-column label="类别名称" align="center" prop="typeName" />
      <el-table-column
        label="规格型号"
        align="center"
        prop="specificationModel"
      />
      <el-table-column label="下料尺寸" align="center" prop="cuttingSize" />
      <el-table-column
        label="可制件数"
        align="center"
        prop="numberProducibleParts"
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
            v-hasPermi="['produce:MaterialListOfTechnology:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['produce:MaterialListOfTechnology:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['produce:MaterialListOfTechnology:remove']"
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

    <!-- 添加或修改需求材料对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        :disabled="view_open"
      >
        <el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="工艺编号" prop="processingTechnologyID">
              <el-input
                v-model="form.processingTechnologyID"
                placeholder="请输入工艺编号"
                disabled
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="材料信息编号" prop="materialID">
              <el-select
                filterable
                v-model="form.materialID"
                placeholder="请选择材料"
                @focus="getListBasicinformationofmaterials()"
              >
                <el-option
                  v-for="(item, index) in BasicinformationofmaterialsList"
                  :key="index"
                  :label="item.name"
                  @click.native="setMaterialInfo(item)"
                  :value="item.id"
                >
                </el-option>
              </el-select> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="材料名称" prop="name">
              <el-input
                v-model="clickBasicinformationofmaterials.name"
                disabled
                placeholder="请输入材料名称"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="材料密度" prop="materialDensity">
              <el-input
                v-model="clickBasicinformationofmaterials.materialDensity"
                disabled
                placeholder="请输入材料密度"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="类别名称" prop="typeName">
              <el-input
                v-model="clickBasicinformationofmaterials.typeName"
                disabled
                placeholder="请输入类别名称"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="规格型号" prop="specificationModel">
              <el-input
                v-model="clickBasicinformationofmaterials.specificationModel"
                disabled
                placeholder="请输入规格型号"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="下料尺寸" prop="cuttingSize">
              <el-input
                v-model="form.cuttingSize"
                placeholder="请输入下料尺寸"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="可制件数" prop="numberProducibleParts">
              <el-input
                v-model="form.numberProducibleParts"
                placeholder="请输入可制件数"
              /> </el-form-item></el-col
        ></el-row>
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
  listMaterialListOfTechnology,
  getMaterialListOfTechnology,
} from "@/api/produce/MaterialListOfTechnology";
import {
  delProcessrequirementmateriallist,
  addProcessrequirementmateriallist,
  updateProcessrequirementmateriallist,
} from "@/api/produce/processrequirementmateriallist";
import {
  listBasicinformationofmaterials,
  getBasicinformationofmaterials,
} from "@/api/storage/basicinformationofmaterials";
export default {
  name: "MaterialListOfTechnology",
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
      // 需求材料表格数据
      MaterialListOfTechnologyList: [],
      // 材料详细信息列表
      BasicinformationofmaterialsList: [],
      // 选中材料信息
      clickBasicinformationofmaterials: {},
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
        id: null,
        materialID: null,
        processingTechnologyID: null,
        name: null,
        materialDensity: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
        cuttingSize: null,
        numberProducibleParts: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        materialID: [
          {
            required: true,
            message: "材料基础信息编号不能为空",
            trigger: "blur",
          },
        ],
        processingTechnologyID: [
          { required: true, message: "工艺编号不能为空", trigger: "blur" },
        ],
        cuttingSize: [
          { required: true, message: "下料尺寸不能为空", trigger: "blur" },
        ],
        numberProducibleParts: [
          { required: true, message: "可制件数不能为空", trigger: "blur" },
        ],
      },
      // 当前是否选中工艺：
      processingtechnology_exist: true,
      // 当前工艺信息
      processingTechnologyID: null,
    };
  },
  created() {
    this.getProcessingtechnologyExist();
  },
  methods: {
    getProcessingtechnologyExist() {
      this.processingtechnology_exist = true;
      this.processingTechnologyID = this.$route.query.id;
      this.queryParams.processingTechnologyID = this.processingTechnologyID;
      this.getList();
    },
    /** 查询需求材料列表 */
    getList() {
      this.loading = true;
      listMaterialListOfTechnology(this.queryParams).then((response) => {
        this.MaterialListOfTechnologyList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询材料详细信息 */
    async getListBasicinformationofmaterials() {
      this.loading = true;
      let total = (await listBasicinformationofmaterials())["total"];

      listBasicinformationofmaterials({ pageSize: total }).then((response) => {
        this.BasicinformationofmaterialsList = response.rows;
        this.loading = false;
      });
    },
    /** 选中材料信息 */
    setMaterialInfo(data) {
      this.clickBasicinformationofmaterials = data;
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
        processingTechnologyID: this.processingTechnologyID,
        cuttingSize: null,
        numberProducibleParts: null,
      };
      this.clickBasicinformationofmaterials = {};
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
      getMaterialListOfTechnology(id).then((response) => {
        this.form = response.data;
        this.view_open = true;
        getBasicinformationofmaterials(response.data.materialID).then(
          (response) => {
            this.clickBasicinformationofmaterials = response.data;
          }
        );
        this.open = true;
        this.title = "修改需求材料";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.view_open = false;
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加需求材料";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.view_open = false;
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getMaterialListOfTechnology(id).then((response) => {
        this.form = response.data;
        getBasicinformationofmaterials(response.data.materialID).then(
          (response) => {
            this.clickBasicinformationofmaterials = response.data;
          }
        );
        this.open = true;
        this.title = "修改需求材料";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateProcessrequirementmateriallist(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProcessrequirementmateriallist(this.form).then((response) => {
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
        .confirm('是否确认删除需求材料编号为"' + ids + '"的数据项？')
        .then(function () {
          return delProcessrequirementmateriallist(ids);
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
        "produce/MaterialListOfTechnology/export",
        {
          ...this.queryParams,
        },
        `MaterialListOfTechnology_${new Date().getTime()}.xlsx`
      );
    },
  },
  watch: {
    "$route.query.id": {
      immediate: true,
      handler() {
        this.getProcessingtechnologyExist();
      },
    },
  },
};
</script>

<style>
.app-container {
  height: 50%;
}
</style>
