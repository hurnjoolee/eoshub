package io.eoshub.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum LoginType {

    KAKAO((byte) 1),

    FACEBOOK((byte) 2);

    private final byte code;

    LoginType(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static LoginType byCode(byte code) {
        switch (code) {
            case 1:
                return KAKAO;
            case 2:
                return FACEBOOK;
        }
        return null;
    }

    public static class TypeHandler extends BaseTypeHandler<LoginType> {

        @Override
        public void setNonNullParameter(PreparedStatement preparedStatement, int integer, LoginType type, JdbcType jdbcType) throws SQLException {
            if (type != null) {
                preparedStatement.setByte(integer, type.getCode());
            }
        }

        @Override
        public LoginType getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
            byte code = resultSet.getByte(columnName);
            return LoginType.byCode(code);
        }

        @Override
        public LoginType getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
            byte code = resultSet.getByte(columnIndex);
            return LoginType.byCode(code);
        }

        @Override
        public LoginType getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
            byte code = callableStatement.getByte(columnIndex);
            return LoginType.byCode(code);
        }

    }

}
