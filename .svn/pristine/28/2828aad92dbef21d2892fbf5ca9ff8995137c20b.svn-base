package com.shtoone.qms.service.bhz;

import java.util.List;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.pojo.base.TSDepart;

import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.V_ShiyanshiInfoEntity;

public interface BanhezhanxinxiServiceI extends CommonService{
	public BanhezhanxinxiEntity getBhzbydepartid(String departid);
	/**
	 * 获取指定组织机构下的拌和机信息
	 * @param departid
	 * @param bhjtype 1:水泥混凝土 2：沥青混凝土 3：万能机 4：压力机
	 * @param userlft
	 * @param userrgt
	 * @return
	 */
	public List<BanhezhanxinxiEntity> getBhzBySql(String departid,String bhjtype,String userlft, String userrgt);
	
	public List<TSDepart> getBHZ(String userlft, String userrgt);
	//通过拌和机的心跳得到其拌合站数据
	public BanhezhanxinxiEntity getBhzByShebeibianhao(String shebeibianhao);
	
	public JSONObject getDatagrid3(BanhezhanxinxiEntity pageObj, DataGrid dataGrid,
			String departid,String gprstype,String smsbaojin,
			String shebeibianhao, String userlft, String userrgt);
	
	public List<V_ShiyanshiInfoEntity> getWNJBySql(String departid,String bhjtype,String userlft, String userrgt);

//	public List<LqBanhezhanxinxiEntity> getLQbhzBySql(String departid,String bhjtype,String userlft, String userrgt);
	
}
