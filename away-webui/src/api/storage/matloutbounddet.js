import request from '@/utils/request'

// 查询材料出库详细列表
export function listMatloutbounddet(query) {
  return request({
    url: '/storage/matloutbounddet/list',
    method: 'get',
    params: query
  })
}

// 查询材料出库详细详细
export function getMatloutbounddet(id) {
  return request({
    url: '/storage/matloutbounddet/' + id,
    method: 'get'
  })
}

// 新增材料出库详细
export function addMatloutbounddet(data) {
  return request({
    url: '/storage/matloutbounddet',
    method: 'post',
    data: data
  })
}

// 修改材料出库详细
export function updateMatloutbounddet(data) {
  return request({
    url: '/storage/matloutbounddet',
    method: 'put',
    data: data
  })
}

// 删除材料出库详细
export function delMatloutbounddet(id) {
  return request({
    url: '/storage/matloutbounddet/' + id,
    method: 'delete'
  })
}
