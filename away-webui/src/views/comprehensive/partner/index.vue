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
      <el-form-item label="供货商姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入供货商姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供货商简称" prop="nameAbbrevation">
        <el-input
          v-model="queryParams.nameAbbrevation"
          placeholder="请输入供货商简称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="社会统一信用代码" prop="unifiedCreditCode">
        <el-input
          v-model="queryParams.unifiedCreditCode"
          placeholder="请输入社会统一信用代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <!-- <el-form-item label="城市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="详细地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入详细地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注信息" prop="notes">
        <el-input
          v-model="queryParams.notes"
          placeholder="请输入备注信息"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['comprehensive:partner:add']"
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
          v-hasPermi="['comprehensive:partner:edit']"
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
          v-hasPermi="['comprehensive:partner:remove']"
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
          v-hasPermi="['comprehensive:partner:export']"
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
      :data="customList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="供货商编号" align="center" prop="id" />
      <el-table-column label="供货商姓名" align="center" prop="name" />
      <el-table-column
        label="供货商简称"
        align="center"
        prop="nameAbbrevation"
      />
      <el-table-column
        label="社会统一信用代码"
        align="center"
        prop="unifiedCreditCode"
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
            @click="handleShow(scope.row)"
            v-hasPermi="['comprehensive:partner:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['comprehensive:partner:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['comprehensive:partner:remove']"
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

    <!-- 查看供货商详细信息对话框 -->
    <el-dialog
      title="供货商信息"
      :visible.sync="isshow"
      width="900px"
      append-to-body
    >
      <el-descriptions :title="view_form.name" border>
        <el-descriptions-item label="供货商编号">{{
          view_form.id
        }}</el-descriptions-item>
        <el-descriptions-item label="供货商姓名">{{
          view_form.name
        }}</el-descriptions-item>
        <el-descriptions-item label="供货商简称">{{
          view_form.nameAbbrevation
        }}</el-descriptions-item>
        <el-descriptions-item label="社会统一信用代码">{{
          view_form.unifiedCreditCode
        }}</el-descriptions-item>
        <el-descriptions-item label="城市地区">{{
          view_form.city
        }}</el-descriptions-item>
        <el-descriptions-item label="详细地址">{{
          view_form.address
        }}</el-descriptions-item>

        <el-descriptions-item label="证照">
          <filedown :files="view_form.files" />
        </el-descriptions-item>

        <el-descriptions-item label="备注信息">
          {{ view_form.notes }}
        </el-descriptions-item>
      </el-descriptions>
    </el-dialog>

    <!-- 添加或修改供货商信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="90px">
        <el-form-item v-if="isadd" label="供货商编号" prop="id">
          <el-input v-model="form.id" placeholder="请输入供货商编号" />
        </el-form-item>
        <el-form-item label="供货商姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入供货商姓名" />
        </el-form-item>
        <el-form-item label="供货商简称" prop="nameAbbrevation">
          <el-input
            v-model="form.nameAbbrevation"
            placeholder="请输入供货商简称"
          />
        </el-form-item>
        <el-form-item label="社会统一信用代码" prop="unifiedCreditCode">
          <el-input
            v-model="form.unifiedCreditCode"
            placeholder="请输入社会统一信用代码"
            minlength="18"
            maxlength="18"
          />
        </el-form-item>
        <el-form-item label="城市地区" prop="cityid">
          <el-cascader
            v-model="form.cityid"
            :options="city_options"
            :props="{ expandTrigger: 'hover' }"
            placeholder="请选择城市地区"
            @change="setCityID"
            clearable
            filterable
          >
          </el-cascader>
        </el-form-item>
        <el-form-item label="详细地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入详细地址" />
        </el-form-item>

        <el-form-item label="证件" prop="certificateURL">
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

        <el-form-item label="备注信息" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入备注信息" />
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
  listCustom,
  getCustom,
  delCustom,
  addCustom,
  updateCustom,
} from "@/api/comprehensive/partner";

import { jsonCity } from "@/api/city/city";

import { fileDownload, fileUpdate } from "@/api/file/file";

import Filedown from "../../../components/FileDown/filedown.vue";

export default {
  name: "Custom",
  components: { filedown: Filedown },

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
      // 供货商信息表格数据
      customList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示表单细节
      isshow: false,
      // 是否新建
      isadd: true,
      // 城市地区选择器
      city_options: [],
      // 城市地区选择器值
      cityid_value: [],
      // 文件列表
      fileList: [],
      // 订单详细查看
      view_form: {},
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        nameAbbrevation: null,
        unifiedCreditCode: null,
        certificateURL: null,
        city: null,
        address: null,
        notes: null,
        type: 1,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "供货商编号不能为空", trigger: "blur" },
        ],
        name: [
          { required: true, message: "供货商姓名不能为空", trigger: "blur" },
        ],
        nameAbbrevation: [
          { required: true, message: "供货商简称不能为空", trigger: "blur" },
        ],
        unifiedCreditCode: [
          {
            required: true,
            message: "社会统一信用代码不能为空",
            trigger: "blur",
          },
          { min: 18, message: "社会统一信用代码不能少于18位", trigger: "blur" },
        ],
        type: [
          { required: true, message: "实体类型不能为空", trigger: "change" },
        ],
        isdel: [
          { required: true, message: "是否删除不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询供货商信息列表 */
    getList() {
      this.loading = true;
      listCustom(this.queryParams).then((response) => {
        this.customList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询城市地区json*/
    getJsonCity() {
      jsonCity({}).then((respones) => {
        this.city_options = respones;
      });
    },
    async fileUpdate() {
      let file_list = this.$refs.upload.uploadFiles;
      if (file_list.length > 0) {
        let num = 0;
        let formData = new FormData();
        for (num in file_list) {
          formData.append("files", file_list[num].raw);
        }
        let response = await fileUpdate(formData);
        this.form.certificateURL = response;
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
        nameAbbrevation: null,
        unifiedCreditCode: null,
        certificateURL: null,
        cityid: null,
        address: null,
        notes: null,
        type: 1,
        isdel: 0,
      };
      this.fileList = [];
      this.resetForm("form");
    },
    setCityID(value) {
      this.form.cityid = value[2];
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
    // 查看详细
    async handleShow(row) {
      this.view_form = row;
      this.view_form.files = [];
      if (row.certificateURL == null) {
        this.isshow = true;
        return 0;
      } else {
        let urls = row.certificateURL.split(";");
        urls.pop();
        let num = 0;
        for (num in urls) {
          let tmp = await fileDownload(urls[num]);
          this.view_form.files.push(tmp);
          console.log(tmp);
        }
      }
      this.isshow = true;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.getJsonCity();
      this.isadd = true;
      this.open = true;
      this.title = "添加供货商信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getJsonCity();
      this.isadd = false;
      const id = row.id || this.ids;
      getCustom(id).then(async (response) => {
        this.form = response.data;
        if (response.data.certificateURL != null) {
          let num = 0;
          let urls = response.data.certificateURL.split(";");
          urls.pop();
          for (num in urls) {
            let tmp = await fileDownload(urls[num]);
            this.fileList.push({ url: tmp.getUrl(), raw: tmp.getFile() });
            console.log(tmp);
          }
        }
        this.open = true;
        this.title = "修改客户信息";
      });
    },
    /** 提交按钮 */
    async submitForm() {
      await this.fileUpdate();
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateCustom(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCustom(this.form).then((response) => {
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
        .confirm('是否确认删除供货商信息编号为"' + ids + '"的数据项？')
        .then(function () {
          return delCustom(ids);
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
        "comprehensive/custom/export",
        {
          ...this.queryParams,
        },
        `custom_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
