import request from '@/utils/request'

// 查询成品检验列表
export function listFinishedproductinspection(query) {
  return request({
    url: '/quality/finishedproductinspection/list',
    method: 'get',
    params: query
  })
}

// 查询成品检验详细
export function getFinishedproductinspection(id) {
  return request({
    url: '/quality/finishedproductinspection/' + id,
    method: 'get'
  })
}

// 新增成品检验
export function addFinishedproductinspection(data) {
  return request({
    url: '/quality/finishedproductinspection',
    method: 'post',
    data: data
  })
}

// 修改成品检验
export function updateFinishedproductinspection(data) {
  return request({
    url: '/quality/finishedproductinspection',
    method: 'put',
    data: data
  })
}

// 删除成品检验
export function delFinishedproductinspection(id) {
  return request({
    url: '/quality/finishedproductinspection/' + id,
    method: 'delete'
  })
}
