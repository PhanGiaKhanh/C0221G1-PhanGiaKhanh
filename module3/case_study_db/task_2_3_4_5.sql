use case_study_db;


-- 2.	Hiển thị thông tin của tất cả nhân viên - có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select *
from nhan_vien
where (
(ho_ten like "H%" or ho_ten like "T%" or ho_ten like "K%")
and length(ho_ten) <= 15
);


-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang
where (
	dia_chi in ("Đà Nẵng", "Quảng Trị")
	and year(now()) - year(ngay_sinh) between 18 and 50
);
-- select *
-- from khach_hang
-- where dia_chi in ("Đà Nẵng", "Quảng Trị");

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.id_khach_hang, lk.ten_loai_khach, kh.ho_ten, count(*) as "so_luong"
from khach_hang kh
join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
where kh.id_loai_khach = 1
group by id_khach_hang
order by count(*);

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
--  (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
--  cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach, dv.ten_dich_vu, hd.ngay_lam_hop_dong, 
hd.ngay_ket_thuc, sum((dvdk.gia*hdct.so_luong)+dv.chi_phi_thue) as "tong_tien"
from khach_hang kh
left join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach 
left join hop_dong hd on  kh.id_khach_hang = hd.id_khach_hang
left join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
left join hop_dong_chi_tiet hdct on  hd.id_hop_dong = hdct.id_hop_dong
left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by id_khach_hang, hd.id_hop_dong;


