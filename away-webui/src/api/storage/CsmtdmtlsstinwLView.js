import request from '@/utils/request'

// 查询客供入库列表
export function listCsmtdmtlsstinwLView(query) {
  return request({
    url: '/storage/CsmtdmtlsstinwLView/list',
    method: 'get',
    params: query
  })
}

// 查询客供入库详细
export function getCsmtdmtlsstinwLView(warehouseEntryID) {
  return request({
    url: '/storage/CsmtdmtlsstinwLView/' + warehouseEntryID,
    method: 'get'
  })
}

// 新增客供入库
export function addCsmtdmtlsstinwLView(data) {
  return request({
    url: '/storage/CsmtdmtlsstinwLView',
    method: 'post',
    data: data
  })
}

// 修改客供入库
export function updateCsmtdmtlsstinwLView(data) {
  return request({
    url: '/storage/CsmtdmtlsstinwLView',
    method: 'put',
    data: data
  })
}

// 删除客供入库
export function delCsmtdmtlsstinwLView(warehouseEntryID) {
  return request({
    url: '/storage/CsmtdmtlsstinwLView/' + warehouseEntryID,
    method: 'delete'
  })
}
