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
          v-hasPermi="['order:contract:add']"
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
          v-hasPermi="['order:contract:edit']"
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
          v-hasPermi="['order:contract:remove']"
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
          v-hasPermi="['order:contract:export']"
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
      :data="contractList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="合同编号" align="center" prop="id" />
      <el-table-column label="合同金额" align="center" prop="money" />
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
            v-hasPermi="['order:contract:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:contract:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:contract:remove']"
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

    <!-- 添加或修改合同存储对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item v-if="isadd" label="合同编号" prop="id">
          <el-input v-model="form.id" placeholder="请输入合同编号" />
        </el-form-item>
        <el-form-item label="合同金额" prop="money">
          <el-input
            type="number"
            v-model="form.money"
            placeholder="请输入合同金额"
          />
        </el-form-item>
        <el-form-item label="合同附件上传" prop="contractURL">
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
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 预览合同对话框 -->
    <el-dialog
      :title="view_form.id"
      :visible.sync="view_open"
      width="800px"
      append-to-body
    >
      <el-descriptions :column="2" border>
        <el-descriptions-item label="合同编号">{{
          view_form.id
        }}</el-descriptions-item>
        <el-descriptions-item label="合同金额">{{
          view_form.money
        }}</el-descriptions-item>
        <el-descriptions-item label="合同附件" :span="2">
          <filedown :files="view_form.files"/>
        </el-descriptions-item>
      </el-descriptions>
    </el-dialog>
  </div>
</template>

<script>

import {
  listContract,
  getContract,
  delContract,
  addContract,
  updateContract,
} from "@/api/order/contract";
import { fileDownload, fileUpdate } from "@/api/file/file";

import Filedown from '../../../components/FileDown/filedown.vue';
export default {
  name: "Contract",
  components:{"filedown":Filedown},
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
      // 合同存储表格数据
      contractList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示详细信息
      view_open: false,
      // 详细信息表单
      view_form: {},
      // 是否新建
      isadd: true,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [{ required: true, message: "合同编号不能为空", trigger: "blur" }],
      },
      // 文件列表
      fileList: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询合同存储列表 */
    getList() {
      this.loading = true;
      listContract(this.queryParams).then((response) => {
        this.contractList = response.rows;
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
        this.form.contractURL = response;
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
        money: null,
        contractURL: null,
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
    /** 查看合同详细信息 */
    // handleView(row) {
    //   const id = row.id || this.ids;
    //   getContract(id).then(async (response) => {
    //     this.view_form = response.data;
    //     this.view_form.files = [];
    //     if (response.data.contractURL != null) {
    //       let num = 0;
    //       let urls = response.data.contractURL.split(";");
    //       urls.pop();
    //       for (num in urls) {
    //         await this.fileDown(urls[num]);
    //       }
    //     }
    //     this.view_open = true;
    //   });
    // },

    async handleView(row) {
      this.view_form=row
     this.view_form.files=[];
     if(row.contractURL==null){
      this.view_open = true
      return 0;
     }else{
      let urls=row.contractURL.split(";");
      urls.pop();
      let num=0;
      for(num in urls){
        let tmp=await fileDownload(urls[num])
        this.view_form.files.push(tmp);
      }
     }
     this.view_open = true
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加合同存储";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getContract(id).then(async (response) => {
        this.form = response.data;
        let num = 0;
        if (response.data.contractURL != null) {
          let urls = response.data.contractURL.split(";");
          urls.pop();
          for (num in urls) {
            let tmp = await fileDownload(urls[num]);
            this.fileList.push({ url: tmp.getUrl(), raw: tmp.getFile() });
          }
        }
        this.open = true;
        this.title = "修改合同存储";
      });
    },
    /** 提交按钮 */
    async submitForm() {
      await this.fileUpdate();
      this.$refs["form"].validate(async (valid) => {
        if (valid) {
          if (!this.isadd) {
            await updateContract(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            await addContract(this.form).then((response) => {
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
        .confirm('是否确认删除合同存储编号为"' + ids + '"的数据项？')
        .then(function () {
          return delContract(ids);
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
        "order/contract/export",
        {
          ...this.queryParams,
        },
        `contract_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
