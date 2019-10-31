package com.example.springbootjdbc.model;

public class cars {
        private int registerNo;
        private String type;
        private String category;

        public cars() {
        }

        public cars(int registerNo, String type, String category) {
            this.registerNo = registerNo;
            this.type = type;
            this.category = category;
        }

        public int getregisterNo() {
            return registerNo;
        }

        public void setregisterNo(int registerNo) {
            this.registerNo = registerNo;
        }

        public String gettype() {
            return type;
        }

        public void settype(String type) {
            this.type = type;
        }

        public String getcategory() {
            return category;
        }

        public void setcategory(String category) {
            this.category = category;
        }
    }


