import request from '@/utils/request'

// 查询本地材料出库列表
export function listLocalmaterialoutbound(query) {
  return request({
    url: '/storage/localmaterialoutbound/list',
    method: 'get',
    params: query
  })
}

// 查询本地材料出库详细
export function getLocalmaterialoutbound(id) {
  return request({
    url: '/storage/localmaterialoutbound/' + id,
    method: 'get'
  })
}

// 新增本地材料出库
export function addLocalmaterialoutbound(data) {
  return request({
    url: '/storage/localmaterialoutbound',
    method: 'post',
    data: data
  })
}

// 修改本地材料出库
export function updateLocalmaterialoutbound(data) {
  return request({
    url: '/storage/localmaterialoutbound',
    method: 'put',
    data: data
  })
}

// 删除本地材料出库
export function delLocalmaterialoutbound(id) {
  return request({
    url: '/storage/localmaterialoutbound/' + id,
    method: 'delete'
  })
}
