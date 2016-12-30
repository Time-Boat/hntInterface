package com.shtoone.qms.dao.impl;


import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.SQLQuery;
import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.shtoone.qms.dao.IDatasubmitDao;


/**
 *
 */
@Repository
public class DatasubmitDao extends GenericBaseCommonDao implements IDatasubmitDao {

	public void executeUpdate(String sql)  throws Exception{
		Statement cs = null;
		Connection con = null;
		try {
			con = SessionFactoryUtils.getDataSource(getSession().getSessionFactory()).getConnection();
			con.setAutoCommit(false);
			cs = con.createStatement();
			cs.executeUpdate(sql);
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			con.rollback();
			throw new Exception(sql + ":" + e.getMessage());
		} finally {			
			try {
				cs.close();
			} catch (Exception e1) {
			}
			try {
				con.close();
			} catch (Exception e) {
			}
		}		
	}
	
	public boolean executeRecordIsnotExits(String sql)  throws Exception{
		boolean rec = true;
		Statement cs = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = SessionFactoryUtils.getDataSource(getSession().getSessionFactory()).getConnection();
			cs = con.createStatement();
			rs = cs.executeQuery(sql);
			if (rs.next()) {
				rec = false;
			}
		} catch (SQLException e) {
			throw new Exception(sql + ":" + e.getMessage());
		} finally {	
			try {
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				cs.close();
			} catch (Exception e1) {
			}
			try {
				con.close();
			} catch (Exception e) {
			}
		}	
		return rec;
	}
	
	public void executeBatchInsert(String sql)  throws Exception{
		Statement cs = null;
		Connection con = null;
		try {
			con = SessionFactoryUtils.getDataSource(getSession().getSessionFactory()).getConnection();
			con.setAutoCommit(false);
			cs = con.createStatement();
			cs.addBatch(sql);
			cs.executeBatch();
			cs.clearBatch();
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			con.rollback();
			throw new Exception(sql + ":" + e.getMessage());
		} finally {			
			try {
				cs.close();
			} catch (Exception e1) {
			}
			try {
				con.close();
			} catch (Exception e) {
			}
		}		
	}

	public void executeUpdate(String sql, ArrayList imagelist)  throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = SessionFactoryUtils.getDataSource(getSession().getSessionFactory()).getConnection();
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);					
			for (int i = 0; i < imagelist.size(); i++) {
				ByteArrayInputStream bin = new ByteArrayInputStream((byte[])imagelist.get(i));
				pst.setBinaryStream(i+1, bin, bin.available());
			}					
			pst.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			imagelist.clear();
		} catch (SQLException e) {
			con.rollback();
			throw new Exception(sql + ":" + e.getMessage());
		} finally {			
			try {
				pst.close();
			} catch (Exception e1) {
			}
			try {
				con.close();
			} catch (Exception e) {
			}
		}	
		
	}
	
	public void getFieldTypes(String tableName, HashMap ftypes) {
		Statement cs = null;
		Connection con = null;
		try {			
			con =  SessionFactoryUtils.getDataSource(getSession().getSessionFactory()).getConnection();
			cs = con.createStatement();
			ftypes.clear();
			ResultSetMetaData md =  cs.executeQuery("SELECT TOP 0 * FROM " + tableName).getMetaData();	
			String fieldName;
	        int fieldType;
	        if (null != md) {
	        	for (int i = 1; i <= md.getColumnCount(); i++) {
	                fieldName = md.getColumnName(i);
	                fieldType = md.getColumnType(i);
	                ftypes.put(fieldName, new Integer(fieldType));
	            }
			}
		} catch (SQLException e) {
		} finally {			
			try {
				cs.close();
			} catch (Exception e1) {
			}
			try {
				con.close();
			} catch (Exception e) {
			}
		}	
    }
}

	
