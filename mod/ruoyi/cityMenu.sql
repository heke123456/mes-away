-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('城市
存储   省，市，县区', '3', '1', 'city', 'city/city/index', 1, 0, 'C', '0', '0', 'city:city:list', '#', 'admin', sysdate(), '', null, '城市
存储   省，市，县区菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('城市
存储   省，市，县区查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'city:city:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('城市
存储   省，市，县区新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'city:city:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('城市
存储   省，市，县区修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'city:city:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('城市
存储   省，市，县区删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'city:city:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('城市
存储   省，市，县区导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'city:city:export',       '#', 'admin', sysdate(), '', null, '');