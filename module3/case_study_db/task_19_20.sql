use case_study_db;

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
-- update    
update dich_vu_di_kem 
set gia = gia * 2
where id_dich_vu_di_kem in (
	select hdct.id_dich_vu_di_kem 
    from hop_dong_chi_tiet hdct
    join hop_dong hd on hdct.id_hop_dong = hd.id_hop_dong
    where year(hd.ngay_lam_hop_dong) = 2019	
    group by hdct.id_dich_vu_di_kem
    having sum(hdct.so_luong) >= 10
);
-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm ID 
-- (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select id_nhan_vien as id, ho_ten, email, sdt, ngay_sinh, dia_chi
from nhan_vien nv
union all
select id_khach_hang as id, ho_ten, email, sdt, ngay_sinh, dia_chi
from khach_hang kh 






