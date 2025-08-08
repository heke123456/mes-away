import request from '@/utils/request'

// 查询客供入库详细列表
export function listDetailcsmtdmtlsstinw(query) {
  return request({
    url: '/storage/detailcsmtdmtlsstinw/list',
    method: 'get',
    params: query
  })
}

// 查询客供入库详细详细
export function getDetailcsmtdmtlsstinw(id) {
  return request({
    url: '/storage/detailcsmtdmtlsstinw/' + id,
    method: 'get'
  })
}

// 新增客供入库详细
export function addDetailcsmtdmtlsstinw(data) {
  return request({
    url: '/storage/detailcsmtdmtlsstinw',
    method: 'post',
    data: data
  })
}

// 修改客供入库详细
export function updateDetailcsmtdmtlsstinw(data) {
  return request({
    url: '/storage/detailcsmtdmtlsstinw',
    method: 'put',
    data: data
  })
}

// 删除客供入库详细
export function delDetailcsmtdmtlsstinw(id) {
  return request({
    url: '/storage/detailcsmtdmtlsstinw/' + id,
    method: 'delete'
  })
}
