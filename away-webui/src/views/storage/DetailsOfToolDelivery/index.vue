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
            <el-form-item label="刀具名称" prop="name">
              <el-input
                v-model="queryParams.name"
                placeholder="请输入刀具名称"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="类别名称" prop="typeName">
              <el-input
                v-model="queryParams.typeName"
                placeholder="请输入类别名称"
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
            <el-form-item label="计量单位" prop="uint">
              <el-input
                v-model="queryParams.uint"
                placeholder="请输入计量单位"
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
      <el-col :span="1.5" v-if="upper_status == '0'">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['storage:DetailsOfToolDelivery:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5" v-if="upper_status == '0'">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['storage:DetailsOfToolDelivery:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5" v-if="upper_status == '0'">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['storage:DetailsOfToolDelivery:remove']"
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
          v-hasPermi="['storage:DetailsOfToolDelivery:export']"
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
      :data="DetailsOfToolDeliveryList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="刀具出库单编号"
        align="center"
        prop="deliveryNoteID"
      />
      <el-table-column
        label="出库数量"
        align="center"
        prop="outboundQuantity"
      />
      <el-table-column label="刀具名称" align="center" prop="name" />
      <el-table-column label="类别名称" align="center" prop="typeName" />

      <el-table-column label="新旧类型" align="center" prop="newAndOldTypes">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_storage_tooloutbound_newandoldtypes"
            :value="scope.row.newAndOldTypes"
          />
        </template>
      </el-table-column>
      <el-table-column
        label="领用用途"
        align="center"
        prop="materialRequisition"
      >
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_storage_tooloutbound_materialrequisition"
            :value="scope.row.materialRequisition"
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
            v-hasPermi="['storage:DetailsOfToolDelivery:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-if="upper_status == '0'"
            v-hasPermi="['storage:DetailsOfToolDelivery:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-if="upper_status == '0'"
            v-hasPermi="['storage:DetailsOfToolDelivery:remove']"
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

    <!-- 添加或修改刀具出库详细对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        :disabled="view_open"
      >
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="出库单编号" prop="deliveryNoteID">
              <el-input
                disabled
                v-model="form.deliveryNoteID"
                placeholder="请输入出库单编号"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="刀具基本信息编号" prop="toolInformationID">
              <el-select
                v-model="form.toolInformationID"
                placeholder="刀具基本信息编号"
                @focus="getListbasicToolInfomations()"
              >
                <el-option
                  v-for="(item, index) in basicToolInfomations"
                  :key="index"
                  :label="item.id"
                  :value="item.id"
                  @click.native="setListbasicToolInfomations(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="出库数量" prop="outboundQuantity">
              <el-input
                v-model="form.outboundQuantity"
                placeholder="请输入出库数量"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="新旧类型" prop="newAndOldTypes">
              <el-select
                v-model="form.newAndOldTypes"
                placeholder="请选择新旧类型"
              >
                <el-option
                  v-for="dict in dict.type
                    .aw_storage_tooloutbound_newandoldtypes"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="领用用途" prop="materialRequisition">
              <el-select
                v-model="form.materialRequisition"
                placeholder="请选择领料用途"
              >
                <el-option
                  v-for="dict in dict.type
                    .aw_storage_tooloutbound_materialrequisition"
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
            <el-form-item label="刀具名称" prop="name">
              <el-input
                disabled
                v-model="basicToolInfomation.name"
                placeholder="请输入刀具名称"
              /> </el-form-item
          ></el-col>
          <el-col :span="12">
            <el-form-item label="类别名称" prop="typeName">
              <el-input
                disabled
                v-model="basicToolInfomation.typeName"
                placeholder="请输入类别名称"
              /> </el-form-item
          ></el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="规格型号" prop="specificationModel">
              <el-input
                disabled
                v-model="basicToolInfomation.specificationModel"
                placeholder="请输入规格型号"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="计量单位" prop="uint">
              <el-input
                disabled
                v-model="basicToolInfomation.uint"
                placeholder="请输入计量单位"
              /> </el-form-item
          ></el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="刀具价格" prop="uint">
              <el-input
                disabled
                v-model="basicToolInfomation.toolPrice"
                placeholder="请输入刀具价格"
              /> </el-form-item
          ></el-col>

          <el-col :span="12">
            <el-form-item label="备注" prop="notes">
              <el-input v-model="form.notes" placeholder="请输入备注" />
            </el-form-item>
          </el-col>
          <el-col :span="12"> </el-col>
        </el-row>
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
  listDetailsOfToolDelivery,
  getDetailsOfToolDelivery,
} from "@/api/storage/DetailsOfToolDelivery";
import {
  listBasicToolInformation,
  getBasicToolInformation,
} from "@/api/storage/BasicToolInformation";

import {
  getToolOutbound,
  delToolOutbound,
  addToolOutbound,
  updateToolOutbound,
} from "@/api/storage/ToolOutbound";

export default {
  name: "DetailsOfToolDelivery",
  dicts: [
    "aw_storage_tooloutbound_newandoldtypes",
    "aw_storage_tooloutbound_materialrequisition",
  ],
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
      // 刀具出库详细表格数据
      DetailsOfToolDeliveryList: [],
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
        name: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
        uint: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        deliveryNoteID: [
          { required: true, message: "出库单编号不能为空", trigger: "blur" },
        ],
        toolInformationID: [
          {
            required: true,
            message: "刀具基本信息编号不能为空",
            trigger: "blur",
          },
        ],
        outboundQuantity: [
          { required: true, message: "出库数量不能为空", trigger: "blur" },
        ],
        newAndOldTypes: [
          { required: true, message: "新旧类型不能为空", trigger: "blur" },
        ],
        materialRequisition: [
          { required: true, message: "领用用途不能为空", trigger: "blur" },
        ],
      },
      // 当前出库单编号
      deliveryNoteID: null,
      // 父单状态
      upper_status: null,
      basicToolInfomations: [],
      basicToolInfomation: {},
    };
  },
  created() {
    this.getExist();
  },

  methods: {
    getExist() {
      this.deliveryNoteID = this.$route.query.id;
      this.queryParams.deliveryNoteID = this.deliveryNoteID;
      this.upper_status = this.$route.query.status;
      this.getList();
    },
    /** 查询刀具出库详细列表 */
    getList() {
      this.loading = true;
      listDetailsOfToolDelivery(this.queryParams).then((response) => {
        this.DetailsOfToolDeliveryList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    //查询刀具基本信息
    async getListbasicToolInfomations() {
      this.loading = true;
      let total = (await listBasicToolInformation())["total"];
      listBasicToolInformation({ pageSize: total }).then((res) => {
        this.basicToolInfomations = res.rows;
        this.loading = false;
      });
    },

    //选中刀具基本信息
    setListbasicToolInfomations(id) {
      this.loading = true;
      getBasicToolInformation(id).then((res) => {
        this.basicToolInfomation = res.data;
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
        deliveryNoteID: this.$route.query.id,
        toolInformationID: null,
        outboundQuantity: null,
        newAndOldTypes: null,
        materialRequisition: null,
        notes: null,
      };
      (this.basicToolInfomations = []),
        (this.basicToolInfomation = {}),
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
      this.add = false;
      const id = row.id || this.ids;
      getToolOutbound(id).then((res) => {
        this.form = res.data;
        this.view_open = true;
        listBasicToolInformation().then((res) => {
          this.basicToolInfomations = res.rows;
        });
        getBasicToolInformation(row.toolInformationID).then((res) => {
          this.basicToolInfomation = res.data;
        });

        this.open = true;
        this.title = "刀具出库详细";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.view_open = false;
      this.title = "添加刀具出库详细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      this.view_open = false;
      getDetailsOfToolDelivery(id).then((response) => {
        this.form = response.data;
        listBasicToolInformation().then((res) => {
          this.basicToolInfomations = res.rows;
        });

        getBasicToolInformation(row.toolInformationID).then((res) => {
          this.basicToolInfomation = res.data;
        });

        this.open = true;
        this.title = "修改刀具出库详细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateToolOutbound(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addToolOutbound(this.form).then((response) => {
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
        .confirm('是否确认删除刀具出库详细编号为"' + ids + '"的数据项？')
        .then(function () {
          return delToolOutbound(ids);
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
        "storage/DetailsOfToolDelivery/export",
        {
          ...this.queryParams,
        },
        `DetailsOfToolDelivery_${new Date().getTime()}.xlsx`
      );
    },
  },

  watch: {
    "$route.query.id": {
      immediate: true,
      handler() {
        this.getExist();
      },
    },
    "this.$route.query.status": {
      immediate: true,
      handler() {
        this.getExist();
      },
    },
  },
};
</script>
