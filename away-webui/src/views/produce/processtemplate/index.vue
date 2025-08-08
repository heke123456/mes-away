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
      <el-form-item label="工序名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入工序名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="工序简图" prop="diagramURL">
        <el-input v-model="queryParams.diagramURL" placeholder="请输入工序简图" clearable @keyup.enter.native="handleQuery" />
      </el-form-item> -->
      <el-form-item label="所用工装" prop="usedTooling">
        <el-input
          v-model="queryParams.usedTooling"
          placeholder="请输入所用工装"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="准备工时" prop="preparationHours">
        <el-input
          v-model="queryParams.preparationHours"
          placeholder="请输入准备工时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单件工时" prop="taktTime">
        <el-input
          v-model="queryParams.taktTime"
          placeholder="请输入单件工时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工时成本" prop="laborCost">
        <el-input
          v-model="queryParams.laborCost"
          placeholder="请输入工时成本"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工序外协" prop="outsourcing">
        <el-select v-model="queryParams.outsourcing" placeholder="请选择状态">
          <el-option
            v-for="(item, index) in isoutsourced"
            :key="index"
            :label="item.value"
            :value="item.key"
          ></el-option>
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
          v-hasPermi="['produce:processtemplate:add']"
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
          v-hasPermi="['produce:processtemplate:edit']"
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
          v-hasPermi="['produce:processtemplate:remove']"
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
          v-hasPermi="['produce:processtemplate:export']"
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
      :data="processtemplateList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工序编号" align="center" prop="id" />
      <el-table-column label="工序名称" align="center" prop="name" />
      <el-table-column label="所用工装" align="center" prop="usedTooling" />
      <el-table-column
        label="准备工时"
        align="center"
        prop="preparationHours"
      />
      <el-table-column label="单件工时" align="center" prop="taktTime" />
      <el-table-column label="工时成本" align="center" prop="laborCost" />
      <el-table-column label="工序外协" align="center" prop="outsourcing">
        <template slot-scope="scope">
          {{ getValue(isoutsourced, scope.row.outsourcing) }}
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
            v-hasPermi="['produce:processtemplate:query']"
            >详细</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['produce:processtemplate:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['produce:processtemplate:remove']"
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

    <!-- 添加或修改工序模板对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="状态" prop="status">
              <el-select v-model="form.status" placeholder="请选择状态">
                <el-option
                  v-for="dict in dict.type.aw_produce_template"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="工序名称" prop="name">
              <el-input v-model="form.name" placeholder="请输入工序名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="所用工装" prop="usedTooling">
              <el-input
                v-model="form.usedTooling"
                placeholder="请输入所用工装"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="准备工时" prop="preparationHours">
              <el-input
                v-model="form.preparationHours"
                placeholder="请输入准备工时"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="单件工时" prop="taktTime">
              <el-input v-model="form.taktTime" placeholder="请输入单件工时" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="工时成本" prop="laborCost">
              <el-input v-model="form.laborCost" placeholder="请输入工时成本" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="工序外协" prop="outsourcing">
              <el-radio-group v-model="form.outsourcing">
                <el-radio
                  v-for="dict in dict.type.aw_produce_outsourcing"
                  :key="dict.value"
                  :label="dict.value"
                  >{{ dict.label }}</el-radio
                >
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="可制件数" prop="quantity">
              <el-input v-model="form.quantity" placeholder="请输入可制件数" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="24">
            <el-form-item label="工序内容" prop="content">
              <editor v-model="form.content" :min-height="192" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="12">
          <el-col :span="24">
            <el-form-item label="工序简图" prop="diagramURL">
              <el-upload
                ref="upload"
                :file-list="fileList"
                action="String"
                :http-request="fileUpdate"
                :auto-upload="false"
                list-type="picture"
              >
                <el-button size="small" type="primary">点击上传</el-button>
                <div slot="tip" class="el-upload__tip">
                  只能上传jpg/png文件，且不超过500kb
                </div>
              </el-upload>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!--  查看工序模板对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="view_open"
      width="900px"
      append-to-body
    >
      <el-descriptions :column="2" border>
        <el-descriptions-item label="工序状态" :span="2">{{
          getValue(state_options, view_form.status)
        }}</el-descriptions-item>
        <el-descriptions-item label="工序名称">{{
          view_form.name
        }}</el-descriptions-item>
        <el-descriptions-item label="所用工装">{{
          view_form.usedTooling
        }}</el-descriptions-item>

        <el-descriptions-item label="准备工时">{{
          view_form.preparationHours
        }}</el-descriptions-item>
        <el-descriptions-item label="单件工时">{{
          view_form.taktTime
        }}</el-descriptions-item>
        <el-descriptions-item label="工时成本">{{
          view_form.laborCost
        }}</el-descriptions-item>
        <el-descriptions-item label="工序外协">{{
          getValue(isoutsourced, view_form.outsourcing)
        }}</el-descriptions-item>
        <!-- <el-descriptions-item label="可制件数">{{
          view_form.quantity
        }}</el-descriptions-item> -->

        <el-descriptions-item label="工序内容" :span="2">
          <div v-html="view_form.content"></div>
        </el-descriptions-item>
        <el-descriptions-item label="产品图纸" :span="2">
          <filedown :files="view_form.files" />
        </el-descriptions-item>
      </el-descriptions>
    </el-dialog>
  </div>
</template>

<script>
import {
  listProcesstemplate,
  getProcesstemplate,
  delProcesstemplate,
  addProcesstemplate,
  updateProcesstemplate,
} from "@/api/produce/processtemplate";
import { fileUpdate, fileDownload, fileDelete } from "@/api/file/file";
import filedown from "@/components/FileDown/filedown.vue";
import Filedown from "../../../components/FileDown/filedown.vue";

export default {
  name: "Processtemplate",
  components: { filedown: Filedown },
  dicts: ["aw_produce_outsourcing", "aw_produce_template"],
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
      // 工序模板表格数据
      processtemplateList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否顯示详细弹出层
      view_open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        content: null,
        diagramURL: null,
        usedTooling: null,
        preparationHours: null,
        taktTime: null,
        laborCost: null,
        outsourcing: null,
        status: null,
      },
      // 工序状态
      state_options: [
        { key: "0", value: "未发布" },
        { key: "1", value: "发布" },
        { key: "2", value: "取消发布" },
      ],
      // 表单参数
      form: {},
      // 预览表单
      view_form: {},
      // 表单校验
      rules: {
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
          { required: true, message: "工序状态不能为空", trigger: "blur" },
        ],
        quantity: [
          { required: true, message: "可制件数不能为空", trigger: "blur" },
        ],
      },
      // 文件列表
      fileList: [],
      // 是否外协
      isoutsourced: [
        { key: "0", value: "否" },
        { key: "1", value: "是" },
      ],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询工序模板列表 */
    getList() {
      this.loading = true;
      listProcesstemplate(this.queryParams).then((response) => {
        this.processtemplateList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 文件上传 */
    async fileUpdate() {
      let file_list = this.$refs.upload.uploadFiles;
      if (file_list.length > 0) {
        let num = 0;
        let formData = new FormData();
        for (num in file_list) {
          formData.append("files", file_list[num].raw);
        }
        let response = await fileUpdate(formData);
        this.form.diagramURL = response;
      }
    },
    /** 文件下载 */
    async fileDown(file_name) {
      let tmp = await fileDownload(file_name);
      this.view_form.files.push(tmp);
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
        name: null,
        content: null,
        diagramURL: null,
        usedTooling: null,
        preparationHours: null,
        taktTime: null,
        laborCost: null,
        quantity: null,
        outsourcing: "0",
        status: "0",
      };
      this.fileList = [];
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
    /** 查看工序详细信息 */
    // handleView(row) {
    //   const id = row.id || this.ids
    //   getProcesstemplate(id).then(async response => {
    //     this.view_form = response.data;
    //     this.view_form.files = [];
    //     let num = 0;
    //     if(response.data.diagramURL == null){}
    //     else{
    //       let urls = response.data.diagramURL.split(";");
    //       urls.pop();
    //       for (num in urls) {
    //         await this.fileDown(urls[num]);
    //       }
    //     }
    //     this.view_open = true;
    //   });
    // },
    async handleView(row) {
      console.log(row);
      this.view_form = row;
      this.view_form.files = [];
      console.log(row.diagramURL);
      this.view_open = true;

      if (row.diagramURL == null) {
        return 0;
      } else {
        let urls = row.diagramURL.split(";");
        urls.pop();
        let num = 0;
        for (num in urls) {
          let tmp = await fileDownload(urls[num]);
          this.view_form.files.push(tmp);
        }
      }
    },
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加工序模板";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getProcesstemplate(id).then(async (response) => {
        console.log(response);
        this.form = response.data;
        let num = 0;
        if (response.data.diagramURL != null) {
          let urls = response.data.diagramURL.split(";");
          urls.pop();
          for (num in urls) {
            let tmp = await fileDownload(urls[num]);
            this.fileList.push({ url: tmp.getUrl(), raw: tmp.getFile() });
          }
        }

        this.open = true;
        this.title = "修改工序模板";
      });
    },
    /** 提交按钮 */
    async submitForm() {
      this.$refs["form"].validate(async (valid) => {
        if (valid) {
          await this.fileUpdate();
          if (this.form.id != null) {
            updateProcesstemplate(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProcesstemplate(this.form).then((response) => {
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
        .confirm('是否确认删除工序模板编号为"' + ids + '"的数据项？')
        .then(function () {
          return delProcesstemplate(ids);
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
        "produce/processtemplate/export",
        {
          ...this.queryParams,
        },
        `processtemplate_${new Date().getTime()}.xlsx`
      );
    },
    // 取出key对应的value
    getValue(dict, key) {
      let num = 0;
      for (num in dict) {
        if (dict[num]["key"] == key) {
          return dict[num]["value"];
        }
      }
      return "未知状态";
    },
  },
};
</script>
