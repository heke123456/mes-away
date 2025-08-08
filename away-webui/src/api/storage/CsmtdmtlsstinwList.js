import request from '@/utils/request'

// 查询客供材料入库单列表
export function listCsmtdmtlsstinwList(query) {
  return request({
    url: '/storage/CsmtdmtlsstinwList/list',
    method: 'get',
    params: query
  })
}

// 查询客供材料入库单详细
export function getCsmtdmtlsstinwList(warehouseEntryID) {
  return request({
    url: '/storage/CsmtdmtlsstinwList/' + warehouseEntryID,
    method: 'get'
  })
}

// 新增客供材料入库单
export function addCsmtdmtlsstinwList(data) {
  return request({
    url: '/storage/CsmtdmtlsstinwList',
    method: 'post',
    data: data
  })
}

// 修改客供材料入库单
export function updateCsmtdmtlsstinwList(data) {
  return request({
    url: '/storage/CsmtdmtlsstinwList',
    method: 'put',
    data: data
  })
}

// 删除客供材料入库单
export function delCsmtdmtlsstinwList(warehouseEntryID) {
  return request({
    url: '/storage/CsmtdmtlsstinwList/' + warehouseEntryID,
    method: 'delete'
  })
}
