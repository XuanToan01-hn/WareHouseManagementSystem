///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package utils;
//
///**
// *
// * @author 
// */
//import dal.LocationDAO;
//import model.Location;
//
//public class LocationValidation {
//
//    public static String validate(Location loc, boolean isEdit, int currentId) {
//        StringBuilder errorMsg = new StringBuilder();
//
//        String name = loc.getName() != null ? loc.getName().trim() : "";
//        String address = loc.getAddress() != null ? loc.getAddress().trim() : "";
//        String description = loc.getDescription() != null ? loc.getDescription().trim() : "";
//
//        LocationDAO dao = new LocationDAO();
//
//        if (name.isEmpty()) {
//            errorMsg.append("Vui lòng nhập tên kho<br>");
//        } else {
//            if (name.length() < 3) {
//                errorMsg.append("Tên kho tối thiểu 3 ký tự<br>");
//            }
//            if (name.length() > 100) {
//                errorMsg.append("Tên kho tối đa 100 ký tự<br>");
//            }
//            if (!name.matches("^[\\p{L}0-9\\s]+$")) {
//                errorMsg.append("Tên kho không được chứa ký tự đặc biệt<br>");
//            }
//            if (name.contains("  ")) {
//                errorMsg.append("Tên kho không được chứa khoảng trắng liên tiếp<br>");
//            }
//
//            Location existing = isEdit
//                    ? dao.getByNameExceptId(name, currentId)
//                    : dao.getByName(name);
//
//            if (existing != null) {
//                errorMsg.append("Tên kho đã tồn tại<br>");
//            }
//        }
//
//        if (address.isEmpty()) {
//            errorMsg.append("Vui lòng nhập địa chỉ<br>");
//        } else {
//            if (address.length() < 5) {
//                errorMsg.append("Địa chỉ tối thiểu 5 ký tự<br>");
//            }
//            if (address.length() > 200) {
//                errorMsg.append("Địa chỉ tối đa 200 ký tự<br>");
//            }
//            if (!address.matches(".*[a-zA-Z\\p{L}]+.*")) {
//                errorMsg.append("Địa chỉ phải chứa ít nhất một ký tự chữ cái<br>");
//            }
//            if (address.contains("  ")) {
//                errorMsg.append("Địa chỉ không được chứa khoảng trắng liên tiếp<br>");
//            }
//            Location addressExisting = isEdit
//                    ? dao.getByAddressExceptId(address, currentId)
//                    : dao.getByAddress(address);
//            if (addressExisting != null) {
//                errorMsg.append("Địa chỉ đã tồn tại<br>");
//            }
//        }
//
//        if (description.length() > 500) {
//            errorMsg.append("Mô tả tối đa 500 ký tự<br>");
//        }
//
//        return errorMsg.toString();
//    }
//}
