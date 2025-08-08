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
            <el-form-item label="订单编号" prop="id">
              <el-input
                v-model="queryParams.id"
                placeholder="请输入订单编号"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="销售单创建日期" prop="createTime">
              <el-date-picker
                clearable
                v-model="queryParams.createTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择销售单创建日期"
              >
              </el-date-picker>
            </el-form-item>
            <el-form-item label="下单日期" prop="orderDate">
              <el-date-picker
                clearable
                v-model="queryParams.orderDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择下单日期"
              >
              </el-date-picker>
            </el-form-item>
            <el-form-item label="需求数量" prop="number">
              <el-input
                v-model="queryParams.number"
                placeholder="请输入需求数量"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="实体姓名" prop="name">
              <el-input
                v-model="queryParams.name"
                placeholder="请输入实体姓名"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>

            <el-form-item label="产品名称" prop="productName">
              <el-input
                v-model="queryParams.productName"
                placeholder="请输入产品名称"
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
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleAllExport"
          v-hasPermi="['produce:productmanhour:export']"
          >导出全部</el-button
        >
      </el-col>
    </el-row>

    <el-table
      v-loading="loading"
      :data="orderhoursdetailedList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />

      <el-table-column label="订单编号" align="center" prop="id" />
      <el-table-column
        label="销售单创建日期"
        align="center"
        prop="createTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="下单日期"
        align="center"
        prop="orderDate"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orderDate, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="需求数量" align="center" prop="number" />
      <el-table-column label="实体姓名" align="center" prop="name" />
      <el-table-column
        label="社会统一信用代码"
        align="center"
        prop="unifiedCreditCode"
      />
      <el-table-column label="产品名称" align="center" prop="productName" />
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
            v-hasPermi="['produce:orderhoursdetailed:query']"
            >查看</el-button
          >

          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleProductView(scope.row)"
            v-hasPermi="['produce:orderhoursdetailed:edit']"
            >查看产品</el-button
          >
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['produce:orderhoursdetailed:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['produce:orderhoursdetailed:remove']"
          >删除</el-button> -->
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

    <!-- 添加或修改工时统计对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="订单id#日期+编号#" prop="id">
          <el-input v-model="form.id" placeholder="请输入订单id#日期+编号#" />
        </el-form-item>
        <el-form-item label="下单日期" prop="orderDate">
          <el-date-picker
            clearable
            v-model="form.orderDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择下单日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="需求数量#要求大于0#" prop="number">
          <el-input
            v-model="form.number"
            placeholder="请输入需求数量#要求大于0#"
          />
        </el-form-item>
        <el-form-item label="实体姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入实体姓名" />
        </el-form-item>
        <el-form-item label="社会统一信用代码" prop="unifiedCreditCode">
          <el-input
            v-model="form.unifiedCreditCode"
            placeholder="请输入社会统一信用代码"
          />
        </el-form-item>
        <el-form-item label="产品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入产品名称" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 预览产品对话框 -->
    <el-dialog
      :title="view_form.id"
      :visible.sync="view_Productopen"
      width="800px"
      append-to-body
    >
      <el-descriptions :column="2" border>
        <el-descriptions-item label="产品图号">{{
          view_form.id
        }}</el-descriptions-item>
        <el-descriptions-item label="产品名称">{{
          view_form.name
        }}</el-descriptions-item>
        <el-descriptions-item label="产品图纸附件" :span="2">
          <el-carousel :interval="4000" type="card" height="200px">
            <el-carousel-item v-for="item in view_form.files" :key="item">
              <el-image :src="item" :preview-src-list="[item]"> </el-image>
            </el-carousel-item>
          </el-carousel>
        </el-descriptions-item>
      </el-descriptions>
    </el-dialog>
  </div>
</template>

<script>
import {
  listOrderhoursdetailed,
  getOrderhoursdetailed,
  delOrderhoursdetailed,
  addOrderhoursdetailed,
  updateOrderhoursdetailed,
} from "@/api/produce/orderhoursdetailed";
import {
  listProduct,
  getProduct,
  delProduct,
  addProduct,
  updateProduct,
} from "@/api/order/product";

import { fileDownload, fileUpdate } from "@/api/file/file";

export default {
  name: "Orderhoursdetailed",
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
      // 工时统计表格数据
      orderhoursdetailedList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示查看窗口
      view_open: false,
      //产品的图
      view_Productopen: false,
      // 是否新增
      isadd: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        state:1,
        id: null,
        createTime: null,
        orderDate: null,
        number: null,
        name: null,
        unifiedCreditCode: null,
        productName: null,
      },
      // 表单参数
      form: {},

      view_form: {},
      // 表单校验

      rules: {
        id: [
          {
            required: true,
            message: "订单id#日期+编号#不能为空",
            trigger: "blur",
          },
        ],
        createTime: [
          {
            required: true,
            message: "销售单创建日期不能为空",
            trigger: "blur",
          },
        ],
        number: [{ required: true, message: "需求数量", trigger: "blur" }],
        name: [
          { required: true, message: "实体姓名不能为空", trigger: "blur" },
        ],
        unifiedCreditCode: [
          {
            required: true,
            message: "社会统一信用代码不能为空",
            trigger: "blur",
          },
        ],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询工时统计列表 */
    getList() {
      this.loading = true;
      listOrderhoursdetailed(this.queryParams).then((response) => {
        this.orderhoursdetailedList = response.rows;
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
        createTime: null,
        orderDate: null,
        number: null,
        name: null,
        unifiedCreditCode: null,
        productName: null,
        drawingURL: null,
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
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    handleView(row) {
      this.view_open = true;
      this.$router.push({
        path: "detailproductmanhour",
        query: { id: row.id, number: row.number },
      });
    },
    //查看产品

    handleProductView(row) {
      const id = row.productID;
      getProduct(id).then(async (response) => {
        this.view_form = response.data;
        this.view_form.files = [];
        if (response.data.drawingURL != null) {
          let num = 0;
          let urls = response.data.drawingURL.split(";");
          urls.pop();
          for (num in urls) {
            await this.fileDown(urls[num]);
          }
        }
        this.view_Productopen = true;
      });
    },

    /** 文件下载 */
    async fileDown(file_name) {
      let tmp = await fileDownload(file_name);
      this.view_form.files.push(tmp.getUrl());
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加工时统计";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getOrderhoursdetailed(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改工时统计";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateOrderhoursdetailed(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrderhoursdetailed(this.form).then((response) => {
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
        .confirm('是否确认删除工时统计编号为"' + ids + '"的数据项？')
        .then(function () {
          return delOrderhoursdetailed(ids);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleAllExport() {
      this.download(
        "produce/orderhoursdetailed/export",
        {
          ...this.queryParams,
        },
        `orderhoursdetailed_${new Date().getTime()}.xlsx`
      );
    },


  
  },
};
</script>
