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
      <!-- 搜索表单 -->
      <el-form-item label="工序序号" prop="number">
        <el-input
          v-model="queryParams.number"
          placeholder="请输入工序序号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工序名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入工序名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- 搜索按钮 -->
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
          v-hasPermi="['produce:processingprocess:add']"
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
          v-hasPermi="['produce:processingprocess:edit']"
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
          v-hasPermi="['produce:processingprocess:remove']"
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
          v-hasPermi="['produce:processingprocess:export']"
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
      :data="processingprocessList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工序编号" align="center" prop="id" />
      <el-table-column label="工序序号" align="center" prop="number" />
      <el-table-column label="工序名称" align="center" prop="name" />
      <el-table-column
        label="加工工艺"
        align="center"
        prop="processingTechnologyID"
      />
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
          <dict-tag
            :options="dict.type.aw_produce_outsource_status"
            :value="scope.row.outsourcing"
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
            v-hasPermi="['produce:processingprocess:query']"
            >详细</el-button
          >

          <el-popover placement="top-start" width="130" trigger="click">
            <el-Image
              style="width: 120px; height: 120px"
              :src="qrcode"
              :preview-src-list="[qrcode]"
            ></el-Image>
            <el-button
              slot="reference"
              size="mini"
              type="text"
              icon="el-icon-share"
              @click="
                getQrCode(
                  productiontasksFormID,
                  productionTasksID,
                  scope.row.id
                )
              "
              >二维码</el-button
            >
          </el-popover>
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

    <!-- 添加或修改加工工序信息对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      :close-on-click-modal="false"
      width="900px"
      append-to-body
    >
      <el-row :gutter="12">
        <el-col :span="12">
          <span
            class="el-form-item__label"
            style="font-weight: 700; padding-left: 12px"
            >模板选择</span
          >
          <div style="margin-bottom: 22px">
            <el-select
              v-model="processtemplate_name"
              placeholder="模板工序"
              filterable
            >
              <el-option
                v-for="(item, index) in processtemplate_list"
                :key="index"
                :label="item.name"
                @click.native="setProcesstemplate(item)"
                :value="item.key"
              ></el-option>
            </el-select>
          </div>
        </el-col>
      </el-row>

      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="工序序号" prop="number">
              <el-input v-model="form.number" placeholder="请输入工序序号" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="加工工艺" prop="processingTechnologyID">
              <el-input
                disabled
                v-model="form.processingTechnologyID"
                placeholder="请输入加工工艺"
              />
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
                  v-for="dict in dict.type.aw_produce_outsource_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                  >{{ dict.label }}
                </el-radio>
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

    <!-- 查看加工工序信息对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="view_open"
      width="900px"
      append-to-body
    >
      <el-descriptions :column="2" border>
        <el-descriptions-item label="工序序号">{{
          view_form.number
        }}</el-descriptions-item>
        <el-descriptions-item label="加工工艺">{{
          view_form.processingTechnologyID
        }}</el-descriptions-item>

        <el-descriptions-item label="工序名称" :span="2">{{
          view_form.name
        }}</el-descriptions-item>
        <el-descriptions-item label="状态"
          ><dict-tag
            :options="dict.type.aw_produce_productionprocess_status"
            :value="view_form.status"
        /></el-descriptions-item>
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
        <el-descriptions-item label="工序外协">
          <dict-tag
            :options="dict.type.aw_produce_outsource_status"
            :value="view_form.outsourcing"
          />
        </el-descriptions-item>
        <el-descriptions-item label="可制件数">{{
          view_form.quantity
        }}</el-descriptions-item>

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
  listProcessingprocess,
  getProcessingprocess,
  delProcessingprocess,
  addProcessingprocess,
  updateProcessingprocess,
} from "@/api/produce/processingprocess";
import { listProcesstemplate } from "@/api/produce/processtemplate";
import { getQrCode } from "@/api/qrcode/qrcode";
import { fileUpdate, fileDownload } from "@/api/file/file";
import filedown from "../../../../../components/FileDown/filedown.vue";

export default {
  name: "ProcessingprocessQr",
  dicts: ["aw_produce_productionprocess_status", "aw_produce_outsource_status"],
  components: { filedown: filedown },
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
      // 加工工序信息
      processingprocessList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示详细信息
      view_open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        processingTechnologyID: null,
        number: null,
        name: null,
        content: null,
        diagramURL: null,
        usedTooling: null,
        preparationHours: null,
        taktTime: null,
        laborCost: null,
        status: null,
        outsourcing: null,
        quantity: null,
      },
      // 表单参数
      form: {},
      // 预览表单
      view_form: {},
      // 表单校验
      rules: {
        processingTechnologyID: [
          { required: true, message: "加工工艺不能为空", trigger: "blur" },
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
        status: [
          { required: true, message: "请选择工序状态", trigger: "blur" },
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
        quantity: [
          { required: true, message: "可制件数不能为空", trigger: "blur" },
        ],
      },
      // 任务单编号
      productiontasksFormID: null,
      // 任务发布状态,
      productionTasks_status: null,
      // 是否存在生产工艺单
      processingtechnology_exist: false,
      // 生产任务编号
      productionTasksID: null,
      // 生产工艺单编号
      processingTechnologyID: null,
      // 文件列表
      fileList: [],
      // 当前模板工序
      processtemplate_name: null,
      // 模板工序列表
      processtemplate_list: [],
      // 二维码
      qrcode: null,
    };
  },

  created() {
    this.getExist();
  },
  methods: {
    async getExist() {
      this.processingTechnologyID = this.$route.query.processingTechnologyID;
      this.productiontasksFormID = this.$route.query.productiontasksFormID;
      this.productionTasksID = this.$route.query.productionTasksID;
      this.queryParams.processingTechnologyID = this.processingTechnologyID;
      this.getList();
    },
    /** 查询加工工序信息列表 */
    getList() {
      this.loading = true;
      this.queryParams.processingTechnologyID = this.processingTechnologyID;
      listProcessingprocess(this.queryParams).then((response) => {
        this.processingprocessList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询模板工序列表 */
    async getListProcesstemplate() {
      let total = (await listProcesstemplate())["total"];
      listProcesstemplate({ status: "1", pageSize: total }).then((response) => {
        this.processtemplate_list = response.rows;
      });
    },
    /** 获取工序对应二维码 */
    getQrCode(productiontasksFormID, productiontasksID, processingprocessID) {
      let query = {
        productiontasksformID: productiontasksFormID,
        productiontasksID: productiontasksID,
        processingprocessID: processingprocessID,
      };
      getQrCode(query).then(async (response) => {
        let tmp = await fileDownload(response.date);
        this.qrcode = tmp.getUrl();
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
    // 设置模板
    async setProcesstemplate(processtemplate) {
      this.processtemplate_name = processtemplate.name;
      Object.keys(processtemplate).forEach((key) => {
        if (key != "id" && key != "status") {
          this.form[key] = processtemplate[key];
        }
      });
      this.fileList = [];
      if (processtemplate.diagramURL != null) {
        let num = 0;
        let urls = processtemplate.diagramURL.split(";");
        urls.pop();
        for (num in urls) {
          let tmp = await fileDownload(urls[num]);
          this.fileList.push({ url: tmp.getUrl(), raw: tmp.getFile() });
        }
      }
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.processtemplate = null;
      this.form = {
        id: null,
        processingTechnologyID: this.processingTechnologyID,
        number: null,
        name: null,
        content: "",
        diagramURL: null,
        usedTooling: null,
        preparationHours: null,
        taktTime: null,
        laborCost: null,
        outsourcing: "0",
        status: "0",
        quantity: null,
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
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 查看工序详细信息 */
    handleView(row) {
      const id = row.id || this.ids;
      getProcessingprocess(id).then(async (response) => {
        this.view_form = response.data;
        this.view_form.files = [];
        let num = 0;
        if (response.data.diagramURL != null) {
          let urls = response.data.diagramURL.split(";");
          urls.pop();
          for (num in urls) {
            await this.fileDown(urls[num]);
          }
        }
        this.view_open = true;
      });
    },

    async handleView(row) {
      this.view_form = row;
      this.view_form.files = [];
      if (row.diagramURL == null) {
        this.view_open = true;
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
      this.view_open = true;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.getListProcesstemplate();
      this.reset();
      this.open = true;
      this.title = "添加加工工序信息";
    },
    /** 修改按钮操作 */
    async handleUpdate(row) {
      this.reset();
      this.getListProcesstemplate();
      const id = row.id || this.ids;
      await getProcessingprocess(id).then(async (response) => {
        this.form = response.data;
        if (response.data.diagramURL != null) {
          let num = 0;
          let urls = response.data.diagramURL.split(";");
          urls.pop();
          for (num in urls) {
            let tmp = await fileDownload(urls[num]);
            this.fileList.push({ url: tmp.getUrl(), raw: tmp.getFile() });
          }
        }
        this.open = true;
        this.title = "修改加工工序信息";
      });
    },
    /** 提交按钮 */
    async submitForm() {
      this.$refs["form"].validate(async (valid) => {
        await this.fileUpdate();
        if (valid) {
          if (this.form.id != null) {
            updateProcessingprocess(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProcessingprocess(this.form).then((response) => {
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
        .confirm('是否确认删除加工工序信息编号为"' + ids + '"的数据项？')
        .then(function () {
          return delProcessingprocess(ids);
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
        "produce/processingprocess/export",
        {
          ...this.queryParams,
        },
        `processingprocess_${new Date().getTime()}.xlsx`
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
  watch: {
    "$route.query.processingTechnologyID": {
      immediate: true,
      handler() {
        this.getExist();
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
