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
      <el-form-item label="创建日期" prop="createTime">
        <el-date-picker
          clearable
          v-model="queryParams.createTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建日期"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="创建人" prop="founder">
        <el-input
          v-model="queryParams.founder"
          placeholder="请输入创建人"
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
          v-hasPermi="['produce:processingtechnology:add']"
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
          v-hasPermi="['produce:processingtechnology:edit']"
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
          v-hasPermi="['produce:processingtechnology:remove']"
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
          v-hasPermi="['produce:processingtechnology:export']"
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
      :data="processingtechnologyList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="加工工艺编号" align="center" prop="id" />
      <el-table-column
        label="创建日期"
        align="center"
        prop="createTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建人" align="center" prop="founder" />
      <el-table-column label="状态" align="center">
        <template slot-scope="scope">
          {{ getValue(state_options, scope.row.status) }}
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
            @click="jumpDetailPage(scope.row)"
            v-hasPermi="['produce:processingtechnology:query']"
          >
            详细</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            >产品详细</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['produce:processingtechnology:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['produce:processingtechnology:remove']"
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

    <!-- 添加或修改加工工艺信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="状态" prop="status">
              <el-select v-model="form.status" placeholder="请选择状态">
                <el-option
                  v-for="(item, index) in state_options"
                  :key="index"
                  :label="item.value"
                  :value="item.key"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="工艺编号" prop="id">
              <el-input
                v-model="form.id"
                placeholder="请输入工艺编号"
                :disabled="!is_add"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="创建人" prop="founder">
              <el-input v-model="form.founder" placeholder="请输入创建人" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="产品图号" prop="productID">
              <el-select
                filterable
                v-model="form.productID"
                placeholder="请输入产品图号"
                @focus="getProductLIst()"
              >
                <el-option
                  v-for="(item, index) in productList"
                  :key="index"
                  :value="item.id"
                  :label="item.id"
                  @click.native="setProduct(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="产品名称">
              <el-input
                disabled
                v-model="product.name"
                placeholder="请输入产品名称"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col>
            <el-form-item label="订单编号" prop="orderID">
              <el-select @focus="getOrderList()" v-model="form.orderID">
                <el-option
                  @click="setOrder"
                  v-for="(item, index) in orderList"
                  :key="index"
                  :value="item.id"
                  :label="item.id"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-form-item label="产品图纸附件" prop="drawingURL">
            <el-upload
              ref="upload"
              :file-list="fileList"
              action="String"
              :http-request="fileUpdate"
              :auto-upload="false"
              list-type="picture"
            >
            </el-upload>
          </el-form-item>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 预览产品对话框 -->
    <el-dialog
      :title="view_form.id"
      :visible.sync="view_open"
      width="800px"
      append-to-body
    >
      <el-descriptions :column="2" border>
        <el-descriptions-item label="工艺编号">{{
          view_form.id
        }}</el-descriptions-item>

        <el-descriptions-item label="创始人">{{
          view_form.founder
        }}</el-descriptions-item>

        <el-descriptions-item label="订单编号">{{
          view_form.orderID
        }}</el-descriptions-item>

        <el-descriptions-item label="产品图号">{{
          view_form.productID
        }}</el-descriptions-item>

        <el-descriptions-item label="产品名称">{{
          view_form.name
        }}</el-descriptions-item>
        <el-descriptions-item label="产品图纸附件" :span="2">
          <filedown :files="view_form.files" />
        </el-descriptions-item>
      </el-descriptions>
    </el-dialog>
  </div>
</template>

<script>
import {
  delProcessingtechnology,
  addProcessingtechnology,
  updateProcessingtechnology,
  getProcessingtechnologyVo,
  listProcessingtechnologyVo,
} from "@/api/produce/processingtechnology";
import { listProduct, getProduct } from "@/api/order/product";
import { fileDownload, fileUpdate } from "@/api/file/file";
import Filedown from "../../../components/FileDown/filedown.vue";

import { listSaleorder, getSaleorder } from "@/api/order/saleorder";
export default {
  components: { filedown: Filedown },
  name: "Processingtechnology",
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
      // 加工工艺信息表格数据
      processingtechnologyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      view_open: null,
      // 是否新增
      is_add: true,

      // 工艺状态
      state_options: [
        { key: "0", value: "未发布" },
        { key: "1", value: "发布" },
        { key: "2", value: "生产中" },
        { key: "3", value: "生产完成" },
        { key: "4", value: "质检中" },
        { key: "5", value: "生产合格" },
        { key: "6", value: "生产不合格" },
      ],

      // 文件列表
      fileList: [],
      // 订单详细查看
      view_form: [],

      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        createTime: null,
        founder: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [{ required: true, message: "工艺编号不能为空", trigger: "blur" }],
        createTime: [
          { required: true, message: "创建日期不能为空", trigger: "blur" },
        ],
        founder: [
          { required: true, message: "创建人不能为空", trigger: "blur" },
        ],
        status: [
          { required: true, message: "创建人不能为空", trigger: "blur" },
        ],
        productID: [
          { required: true, message: "图号不能为空", trigger: "blur" },
        ],
        orderID: [{ required: true, message: "订单不能为空", trigger: "blur" }],
      },
      productList: [],
      product: {},
      orderList: [],
      order: {},
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询加工工艺信息列表 */
    getList() {
      this.loading = true;
      listProcessingtechnologyVo(this.queryParams).then((response) => {
        this.processingtechnologyList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    async getProductLIst() {
      let total = (await listProduct())[`total`];
      listProduct({ pageSize: total }).then((response) => {
        this.productList = response.rows;
      });
    },

    setProduct(id) {
      getProduct(id).then(async (response) => {
        this.product = response.data;
        this.fileList = [];
        if (this.product.drawingURL != null) {
          let urls = this.product.drawingURL.split(";");
          console.log(urls);
          urls.pop();
          let num = 0;
          for (num in urls) {
            let tmp = await fileDownload(urls[num]);
            this.fileList.push(tmp);
          }
        } else {
          return;
        }
      });
    },

    async getOrderList() {
      let total = (await listSaleorder())[`total`];

      listSaleorder({ pageSize: total }).then((response) => {
        this.orderList = response.rows;
      });
    },
    setOrder(id) {
      this.loading = true;
      getSaleorder(id).then((response) => {
        this.order = response.data;
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
        this.form.drawingURL = response;
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
        createTime: null,
        founder: null,
        status: "0",
        productID: null,
        orderId: null,
      };
      this.resetForm("form");

      this.product = {};
      this.productList = [];
      this.orderList = [];
      this.order = {};

      this.fileList = [];
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
    /** 跳转详情页面 */
    async jumpDetailPage(row) {
      let id = row.id;
      this.$router.push({ path: "/produce/processdetails", query: { id: id } });
    },

    //查看详细

    async handleView(row) {
      this.view_form = row;
      this.view_form.files = [];
      if (row.drawingURL == null) {
        this.view_open = true;
        return 0;
      } else {
        let urls = row.drawingURL.split(";");
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
      this.reset();
      this.is_add = true;
      this.open = true;
      this.title = "添加加工工艺信息";
    },

    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.is_add = false;
      const id = row.id || this.ids;
      getProcessingtechnologyVo(id).then((response) => {
        this.form = response.data;

        this.getOrderList();

        getProduct(row.productID).then(async (response) => {
          this.product = response.data;
          console.log(this.product);
          console.log(response.data);

          this.fileList = [];
          if (this.product.drawingURL != null) {
            let urls = this.product.drawingURL.split(";");
            console.log(urls);
            urls.pop();
            let num = 0;
            for (num in urls) {
              let tmp = await fileDownload(urls[num]);
              this.fileList.push(tmp);
            }
          } else {
            return;
          }
        });
        this.open = true;
        this.title = "修改加工工艺信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.is_add == false) {
            updateProcessingtechnology(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProcessingtechnology(this.form).then((response) => {
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
        .confirm('是否确认删除加工工艺信息编号为"' + ids + '"的数据项？')
        .then(function () {
          return delProcessingtechnology(ids);
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
        "produce/processingtechnology/export",
        {
          ...this.queryParams,
        },
        `processingtechnology_${new Date().getTime()}.xlsx`
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
