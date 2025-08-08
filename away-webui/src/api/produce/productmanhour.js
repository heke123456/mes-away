import request from '@/utils/request'

// 查询生产工时列表
export function listProductmanhour(query) {
  return request({
    url: '/produce/productmanhour/list',
    method: 'get',
    params: query
  })
}

// 查询生产工时详细
export function getProductmanhour(id) {
  return request({
    url: '/produce/productmanhour/' + id,
    method: 'get'
  })
}

// 新增生产工时
export function addProductmanhour(data) {
  return request({
    url: '/produce/productmanhour',
    method: 'post',
    data: data
  })
}



// 修改生产工时
export function updateProductmanhour(data) {
  return request({
    url: '/produce/productmanhour',
    method: 'put',
    data: data
  })
}

// 删除生产工时
export function delProductmanhour(id) {
  return request({
    url: '/produce/productmanhour/' + id,
    method: 'delete'
  })
}


// 新增生产工时
export function addProductmanhourVo(data) {
  return request({
    url: '/produce/productmanhour/Vo',
    method: 'post',
    data: data
  })
}


// 查询生产工时详细
export function getProductmanhourVo(id) {
  return request({
    url: '/produce/productmanhour/Vo/' + id,
    method: 'get'
  })
}

// 修改生产工时
export function updateProductmanhourVo(data) {
  return request({
    url: '/produce/productmanhour/Vo/',
    method: 'put',
    data: data
  })
}