use database_furama;

DELIMITER $$
create procedure get_information()
begin
	select cd.contract_detail_id, c.contract_id, ats.attach_service_id, cd.quantity, ats.attach_service_name , s.service_name
    from contract_detail cd 
    join contract c on c.contract_id = cd.contract_id
    join attach_service ats on ats.attach_service_id = cd.attach_service_id
    join service s on s.service_id = c.service_id;
end $$
DELIMITER ;

call get_information();


-- ---------------------- tính tổng tiền
DELIMITER $$
create procedure getTotal(in id int)
begin
	select max(max(ats.attach_service_cost * cd.quantity) + s.service_cost)
    from contract c 
    join service s  on s.service_id = c.service_id
    join contract_detail cd on cd.contract_id = c.contract_id
    join attach_service ats on ats.attach_service_id = cd.attach_service_id
    group by c.service_id;
end $$
DELIMITER ;


	select c.contract_id, max(ats.attach_service_cost * cd.quantity) as total_attch
    from contract c 
    join contract_detail cd on cd.contract_id = c.contract_id
    join attach_service ats on ats.attach_service_id = cd.attach_service_id
    group by c.service_id;
    
    
-- 8.	Tạo màn hình liệt kê danh sách các khách hàng đang sử dụng dịch vụ tại resort 
-- (Dạng bảng, có phân trang, nhảy trang, tìm kiếm, liên kết đến các chức năng xóa và 
-- chỉnh sửa thông tin của Dịch vụ). Nếu hợp đồng có sử dụng dịch vụ đính kèm thì hãy 
-- liệt kê các dịch vụ đính kèm đó ra.
-- (sử dụng bảng customer, contract, contract_detail, attach_service)
drop view customer_use_service;
create view customer_use_service as
	select c.contract_id, cus.customer_id, s.service_id,
    c.contract_start_date, c.contract_end_date,cus.customer_name, cus.customer_phone,s.service_name, s.service_cost
    from contract c 
    join service s on s.service_id = c.service_id
    join customer cus on cus.customer_id = c.customer_id
    where current_date() between c.contract_start_date and c.contract_end_date
    group by c.contract_id;
select * from customer_type;
