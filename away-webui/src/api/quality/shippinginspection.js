import request from '@/utils/request'

// 查询成品出货检验列表
export function listShippinginspection(query) {
  return request({
    url: '/quality/shippinginspection/list',
    method: 'get',
    params: query
  })
}

// 查询成品出货检验详细
export function getShippinginspection(id) {
  return request({
    url: '/quality/shippinginspection/' + id,
    method: 'get'
  })
}

// 新增成品出货检验
export function addShippinginspection(data) {
  return request({
    url: '/quality/shippinginspection',
    method: 'post',
    data: data
  })
}

// 修改成品出货检验
export function updateShippinginspection(data) {
  return request({
    url: '/quality/shippinginspection',
    method: 'put',
    data: data
  })
}

// 删除成品出货检验
export function delShippinginspection(id) {
  return request({
    url: '/quality/shippinginspection/' + id,
    method: 'delete'
  })
}
