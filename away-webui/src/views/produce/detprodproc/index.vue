<template>
  <div class="app-container">
    <el-form
      disabled
      ref="form"
      :model="form"
      :rules="rules"
      label-width="80px"
    >
      <el-form-item label="生产任务单编号" prop="productionTasksFormID">
        <el-input
          v-model="form.productionTasksFormID"
          placeholder="请输入生产任务单编号"
        />
      </el-form-item>
      <el-form-item label="任务编号" prop="productionTasksID">
        <el-input
          v-model="form.productionTasksID"
          placeholder="请输入任务编号"
        />
      </el-form-item>
      <el-form-item label="工艺编号" prop="processingTechnologyID">
        <el-input
          v-model="form.processingTechnologyID"
          placeholder="请输入工艺编号"
        />
      </el-form-item>
      <el-form-item label="工序编号" prop="processingprocessID">
        <el-input
          v-model="form.processingprocessID"
          placeholder="请输入工序编号"
        />
      </el-form-item>
      <el-form-item label="工序序号" prop="number">
        <el-input v-model="form.number" placeholder="请输入工序序号" />
      </el-form-item>
      <el-form-item label="工序名称" prop="name">
        <el-input v-model="form.name" placeholder="请输入工序名称" />
      </el-form-item>
      <el-form-item label="工序内容">
        <editor v-model="form.content" :min-height="192" />
      </el-form-item>
      <el-form-item label="工序简图URL" prop="diagramURL">
        <image-upload v-model="form.diagramURL" />
      </el-form-item>
      <el-form-item label="所用工装" prop="usedTooling">
        <el-input v-model="form.usedTooling" placeholder="请输入所用工装" />
      </el-form-item>
      <el-form-item label="准备工时" prop="preparationHours">
        <el-input
          v-model="form.preparationHours"
          placeholder="请输入准备工时"
        />
      </el-form-item>
      <el-form-item label="单件工时" prop="taktTime">
        <el-input v-model="form.taktTime" placeholder="请输入单件工时" />
      </el-form-item>
      <el-form-item label="工时成本" prop="laborCost">
        <el-input v-model="form.laborCost" placeholder="请输入工时成本" />
      </el-form-item>
      <el-form-item label="工序外协" prop="outsourcing">
        <el-input v-model="form.outsourcing" placeholder="请输入工序外协" />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="form.status" placeholder="请选择状态">
          <el-option
            v-for="dict in dict.type.aw_produce_productionprocess_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          ></el-option>
        </el-select>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {
  getDetprodproc,
  delDetprodproc,
  addDetprodproc,
  updateDetprodproc,
} from "@/api/produce/detprodproc";

export default {
  name: "Detprodproc",
  dicts: ["aw_produce_productionprocess_status"],
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
      // 生产工艺工序详细表格数据
      detprodprocList: [],
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
        productionTasksID: null,
        processingprocessID: null,
        number: null,
        name: null,
        outsourcing: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        productionTasksFormID: [
          {
            required: true,
            message: "生产任务单编号不能为空",
            trigger: "blur",
          },
        ],
        productionTasksID: [
          { required: true, message: "任务编号不能为空", trigger: "blur" },
        ],
        processingprocessID: [
          { required: true, message: "工序编号不能为空", trigger: "blur" },
        ],
        number: [
          { required: true, message: "工序序号不能为空", trigger: "blur" },
        ],
        name: [
          { required: true, message: "工序名称不能为空", trigger: "blur" },
        ],
        content: [
          { required: true, message: "工序内容不能为空", trigger: "blur" },
        ],
        usedTooling: [
          { required: true, message: "所用工装不能为空", trigger: "blur" },
        ],
        preparationHours: [
          { required: true, message: "准备工时不能为空", trigger: "blur" },
        ],
        taktTime: [
          { required: true, message: "单件工时不能为空", trigger: "blur" },
        ],
        laborCost: [
          { required: true, message: "工时成本不能为空", trigger: "blur" },
        ],
        outsourcing: [
          { required: true, message: "工序外协不能为空", trigger: "blur" },
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "change" },
        ],
      },
      // 任务单id
      productionTasksFormID: null,
      // 任务id
      productiontasksID: null,
      // 工序id
      processingprocessID: null,
    };
  },
  created() {
    this.getExist();
  },
  methods: {
    getExist() {
      this.loading = true;
      this.productionTasksFormID = this.$route.query.productiontasksformID;
      this.productiontasksID = this.$route.query.productiontasksID;
      this.processingprocessID = this.$route.query.processingprocessID;
      this.getDetprodproc();
      this.loading = false;
    },
    /** 查询生产工艺工序详细列表 */
    getDetprodproc() {
      this.loading = true;
      let query = {
        productionTasksFormID: this.productionTasksFormID,
        productionTasksID: this.productiontasksID,
        processingprocessID: this.processingprocessID,
      };
      getDetprodproc(query).then((response) => {
        console.log(response);
        this.form = response.data;
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
        productionTasksFormID: null,
        productionTasksID: null,
        processingTechnologyID: null,
        processingprocessID: null,
        number: null,
        name: null,
        content: null,
        diagramURL: null,
        usedTooling: null,
        preparationHours: null,
        taktTime: null,
        laborCost: null,
        outsourcing: null,
        status: null,
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
      this.ids = selection.map((item) => item.productionTasksFormID);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    handleView(row) {
      this.view_open = true;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加生产工艺工序详细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const productionTasksFormID = row.productionTasksFormID || this.ids;
      getDetprodproc(productionTasksFormID).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改生产工艺工序详细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateDetprodproc(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDetprodproc(this.form).then((response) => {
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
      const productionTasksFormIDs = row.productionTasksFormID || this.ids;
      this.$modal
        .confirm(
          '是否确认删除生产工艺工序详细编号为"' +
            productionTasksFormIDs +
            '"的数据项？'
        )
        .then(function () {
          return delDetprodproc(productionTasksFormIDs);
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
        "produce/detprodproc/export",
        {
          ...this.queryParams,
        },
        `detprodproc_${new Date().getTime()}.xlsx`
      );
    },
  },
  watch: {
    "this.$route.query.processingprocessID": {
      immediate: true,
      handler() {
        this.getExist();
      },
    },
  },
};
</script>
