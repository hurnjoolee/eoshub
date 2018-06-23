package io.eoshub.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum FileCategoryType {

    AD_AIRDROP((byte) 1),
    
    AD_ICO((byte) 2);

    private final byte code;

    FileCategoryType(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static FileCategoryType byCode(byte code) {
        switch (code) {
            case 1:
                return AD_AIRDROP;
            case 2:
                return AD_ICO;
        }
        return null;
    }

    public static class TypeHandler extends BaseTypeHandler<FileCategoryType> {

        @Override
        public void setNonNullParameter(PreparedStatement preparedStatement, int integer, FileCategoryType type, JdbcType jdbcType) throws SQLException {
            if (type != null) {
                preparedStatement.setByte(integer, type.getCode());
            }
        }

        @Override
        public FileCategoryType getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
            byte code = resultSet.getByte(columnName);
            return FileCategoryType.byCode(code);
        }

        @Override
        public FileCategoryType getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
            byte code = resultSet.getByte(columnIndex);
            return FileCategoryType.byCode(code);
        }

        @Override
        public FileCategoryType getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
            byte code = callableStatement.getByte(columnIndex);
            return FileCategoryType.byCode(code);
        }

    }

}
