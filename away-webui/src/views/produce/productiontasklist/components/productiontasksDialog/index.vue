<template>
  <el-main>
    <!-- 生产任务 -->
    <el-divider>生产任务</el-divider>
    <div
      v-if="productiontasks_list.length < 1"
      style="display: flex; justify-content: center; align-items: center"
    >
      <el-button
        type="primary"
        size="mini"
        icon="el-icon-plus"
        @click="handleAddProductiontasks()"
      ></el-button>
    </div>
    <el-table
      :data="productiontasks_list"
      max-height="500px"
      v-if="productiontasks_list.length > 0"
    >
      <el-table-column label="序号" align="center" width="100">
        <template slot-scope="scope">
          {{ (scope.row.serialNum = scope.$index) }}
        </template>
      </el-table-column>

      <el-table-column label="生产任务id" align="center" width="100">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="销售订单" align="center" width="400">
        <template slot-scope="scope">
          <el-select
            style="width: 300px"
            v-model="scope.row.saleOrderID"
            placeholder="请选择销售订单"
            filterable
          >
            <el-option
              v-for="item in saleorder_list"
              :key="item.id"
              :label="
                item.customername + '的' + item.id + '批-' + item.lotNumber
              "
              :value="item.id"
            >
            </el-option>
          </el-select>
        </template>
      </el-table-column>

      <!-- <el-table-column label="批次号" align="center">
        <template slot-scope="scope">
          <el-select
            disabled
            v-model="scope.row.saleOrderID"
            placeholder="请选择批次号"
            filterable
          >
            <el-option
              v-for="item in saleorder_list"
              :key="item.id"
              :label="item.lotNumber"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </template>
      </el-table-column> -->

      <el-table-column label="产品编号" align="center" width="200">
        <template slot-scope="scope">
          <el-select
            style="width: 150px"
            disabled
            v-model="scope.row.saleOrderID"
            placeholder="请选择销售订单"
            filterable
          >
            <el-option
              v-for="item in saleorder_list"
              :key="item.id"
              :label="item.productID"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </template>
      </el-table-column>

      <el-table-column label="生产工艺" align="center">
        <template slot-scope="scope">
          <el-select
            v-model="scope.row.processingTechnologyID"
            placeholder="请选择生产工艺"
            filterable
          >
            <el-option
              v-for="item in processingtechnology_list"
              :key="item.id"
              :label="item.id"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column label="外协" align="center">
        <template slot-scope="scope">
          <el-radio-group v-model="scope.row.outsourced">
            <el-radio
              v-for="dict in dict.type.aw_produce_outsourcing"
              :key="dict.value"
              :label="dict.value"
              >{{ dict.label }}</el-radio
            >
          </el-radio-group>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center">
        <template slot-scope="scope">
          <el-select
            v-model="scope.row.status"
            :disabled="scope.row.processingTechnologyID != null ? false : true"
          >
            <el-option
              v-for="dict in dict.type.aw_produce_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            >
            </el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column label="简称" align="center">
        <template slot-scope="scope">
          <el-input v-model="scope.row.notes" placeholder="请输入简称" />
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button
            v-if="
              scope.row.id != null &&
              scope.row.status == '1' &&
              scope.row.processingTechnologyID != null
            "
            :disabled="false"
            type="text"
            size="mini"
            icon="el-icon-view"
            @click="jumpDetailPage(scope.row)"
            >详细</el-button
          >
          <el-button
            type="text"
            size="mini"
            icon="el-icon-plus"
            @click="handleAddProductiontasks()"
            >{{ scope.row.state }}新增</el-button
          >
          <el-button
            type="text"
            size="mini"
            icon="el-icon-minus"
            @click="handleRemoveProductiontasks(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-divider></el-divider>
    <!-- 生产任务 end -->
  </el-main>
</template>

<script>
import { listSaleorder } from "@/api/order/saleorder";
import {
  listProductiontasks,
  delProductiontasks,
  addProductiontasks,
  updateProductiontasks,
} from "@/api/produce/productiontasks";
import { listProcessingtechnology } from "@/api/produce/processingtechnology";

export default {
  name: "ProductiontasksDialog",
  dicts: ["aw_produce_status", "aw_produce_outsourcing"],

  props: ["proformid"],
  data() {
    return {
      // 任务单状态
      state_options: [
        { key: "0", value: "未发布" },
        { key: "1", value: "发布" },
        { key: "2", value: "暂停" },
        { key: "3", value: "完成" },
        { key: "4", value: "取消" },
      ],
      // 是否外协
      isoutsourced: [
        { key: "0", value: "否" },
        { key: "1", value: "是" },
      ],

      rules: {},

      // 生产任务列表
      productiontasks_list: [],
      // 删除任务队列
      del_productiontasks_list: [],
      // 销售订单表单
      saleorder_list: [],
      // 生产工艺列表
      processingtechnology_list: [],
      // 生成任务单ID
      productiontasksFormID: this.proformid,
      //任务编号
      productionTasksID: null,
      // 初始化produceformid参数
      produceformid: this.proformid,
    };
  },
  created() {
    this.loading = true;
    this.reset();
    this.getListSaleorder();
    this.getListProcessingtechnology();
    this.getListProductiontasks(this.proformid);
    this.loading = false;
  },
  methods: {
    /** 查询销售订单列表 */
    async getListSaleorder() {
      this.loading = true;

      let total = (await listSaleorder({ state: "1" }))["total"];

      listSaleorder({ state: "1", pageSize: total }).then((response) => {
        this.saleorder_list = response.rows;
        this.loading = false;
      });
    },
    /** 查询生产工艺列表 */
    async getListProcessingtechnology() {
      this.loading = true;

      let total = (await listProcessingtechnology({ state: "1" }))["total"];

      listProcessingtechnology({ state: "1", pageSize: total }).then(
        (response) => {
          this.processingtechnology_list = response.rows;
          this.loading = false;
        }
      );
    },
    /** 跳转详情页面 */
    async jumpDetailPage(row) {
      let processingTechnologyID = row.processingTechnologyID;
      let query = {
        processingTechnologyID: processingTechnologyID,
        productionTasksID: row.id,
        id: processingTechnologyID,
        productiontasksFormID: this.productiontasksFormID,
      };
      this.$router.push({ path: "/produce/ProcessDetailsTask", query: query });
    },
    /** 提交需修改或添加的任务 */
    async submitUpDateOrAddProductiontasks() {
      if (this.productiontasks_list.length > 0) {
        let num = 0;
        for (num in this.productiontasks_list) {
          let tmp_productiontasks = this.productiontasks_list[num];
          if (tmp_productiontasks.saleOrderID == null) {
            continue;
          }
          if (tmp_productiontasks.id == null) {
            tmp_productiontasks.productionTasksFormID = this.produceformid;
            let response = await addProductiontasks(tmp_productiontasks);
          } else {
            let response = await updateProductiontasks(tmp_productiontasks);
          }
        }
      }
    },
    /** 提交需要删除的表单 */
    async submitDelProductiontasks() {
      if (this.del_productiontasks_list.length > 0) {
        let num = 0;
        for (num in this.del_productiontasks_list) {
          await delProductiontasks(this.del_productiontasks_list[num]);
        }
      }
    },
    /** 提交 */
    async submitForm() {
      await this.submitUpDateOrAddProductiontasks();
      await this.submitDelProductiontasks();
    },
    /** 新增生产任务表单 */
    handleAddProductiontasks() {
      let productiontasks_form = {
        id: null,
        productionTasksFormID: null,
        serialNum: null,
        saleOrderID: null,
        outsourced: "0",
        status: "0",
        notes: null,
      };
      this.productiontasks_list.push(productiontasks_form);
    },
    /** 移除生产任务表单 */
    handleRemoveProductiontasks(index, item) {
      this.productiontasks_list.splice(index, 1);
      if (item.id != null) {
        this.del_productiontasks_list.push(item.id);
      }
    },
    /** 获取生成任务单对应任务 */
    async getListProductiontasks(id) {
      let total = (await listProductiontasks())["total"];

      if (id == null) {
      } else {
        listProductiontasks({
          productionTasksFormID: id,
          pageSize: total,
        }).then((response) => {
          this.productiontasks_list = response.rows;
        });
      }
    },
    /** 重置任务列表 */
    reset() {
      this.productiontasks_list = [];
    },
  },
  watch: {
    produceformid(newval, oldval) {
      if (newval != null) {
        this.reset();
        this.getListProductiontasks(newval);
      } else {
        this.reset();
      }
    },
  },
};
</script>

<style></style>
