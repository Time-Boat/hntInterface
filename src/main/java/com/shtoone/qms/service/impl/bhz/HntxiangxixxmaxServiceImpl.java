package com.shtoone.qms.service.impl.bhz;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.service.bhz.HntxiangxixxmaxServiceI;
import com.shtoone.qms.service.bhz.SmsrecordServiceI;
import com.shtoone.qms.service.bhz.TopRealMaxhunnintuViewServiceI;

import org.apache.commons.beanutils.BeanUtils;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.shtoone.qms.entity.bhz.HntxiangxixxmaxEntity;
import com.shtoone.qms.entity.bhz.TopRealMaxhunnintuViewEntity;

@Service("hntxiangxixxmaxService")
@Transactional
public class HntxiangxixxmaxServiceImpl extends CommonServiceImpl implements HntxiangxixxmaxServiceI {
	@Autowired
	private TopRealMaxhunnintuViewServiceI topmaxhntview;
	
	
	public void getMaxhntxx() {
		List<TopRealMaxhunnintuViewEntity> th = topmaxhntview.loadAll(TopRealMaxhunnintuViewEntity.class);
		/*if (th.size() > 0) {
			xxmaxDAO.deleteAll(xxmaxDAO.loadAll());
		}*/
		for (TopRealMaxhunnintuViewEntity topv : th) {
            try {
                   List<HntxiangxixxmaxEntity> maxlist = this.findHql(" from HntxiangxixxmaxEntity where shebeibianhao =? ",topv.getShebeibianhao());
	       if (maxlist.size()>0) {
	    	   String sql = null;   
	    	   sql="update Hntxiangxixxmax set ambegin='"+topv.getAmbegin()+"' , amend='"+topv.getAmend()+
	    			   "' , baocunshijian='"+topv.getBaocunshijian()+"' , biaoshi='"+topv.getBiaoshi()+"' , caijishijian='"+topv.getCaijishijian()+
	    			   "' , chaozuozhe='"+topv.getChaozuozhe()+"' , chuliaoshijian='"+topv.getChuliaoshijian()+"' , departid='"+topv.getDepartid()+
	    			   "' ,  gongdanhao='"+topv.getGongdanhao()+"' , sha1_shijizhi='"+topv.getSha1Shijizhi()+"' , shi1_shijizhi='"+topv.getShi1Shijizhi()+
	    			   "' , shi2_shijizhi='"+topv.getShi2Shijizhi()+"' , sha2_shijizhi='"+topv.getSha2Shijizhi()+"' , guliao5_shijizhi='"+topv.getGuliao5Shijizhi()+
	    			   "' , shuini1_shijizhi='"+topv.getShuini1Shijizhi()+"' , shuini2_shijizhi='"+topv.getShuini2Shijizhi()+"' , kuangfen3_shijizhi='"+topv.getKuangfen3Shijizhi()+
	    			   "' , feimeihui4_shijizhi='"+topv.getFeimeihui4Shijizhi()+"' , fenliao5_shijizhi='"+topv.getFenliao5Shijizhi()+"' , fenliao6_shijizhi='"+topv.getFenliao6Shijizhi()+
	    			   "' , shui1_shijizhi='"+topv.getShui1Shijizhi()+"' , shui2_shijizhi='"+topv.getShui2Shijizhi()+
	    			   "' , waijiaji1_shijizhi='"+topv.getWaijiaji1Shijizhi()+"' , waijiaji2_shijizhi='"+topv.getWaijiaji2Shijizhi()+
	    			   "' , waijiaji3_shijizhi='"+topv.getWaijiaji3Shijizhi()+"' , waijiaji4_shijizhi='"+topv.getWaijiaji4Shijizhi()+
	    			   "' , sha1_lilunzhi='"+topv.getSha1Lilunzhi()+"' , shi1_lilunzhi='"+topv.getShi1Lilunzhi()+
	    			   "' , shi2_lilunzhi='"+topv.getShi2Lilunzhi()+"' , sha2_lilunzhi='"+topv.getSha2Lilunzhi()+
	    			   "' , guliao5_lilunzhi='"+topv.getGuliao5Lilunzhi()+"' , shuini1_lilunzhi='"+topv.getShuini1Lilunzhi()+
	    			   "' , shuini2_lilunzhi='"+topv.getShuini2Shijizhi()+"' , kuangfen3_lilunzhi='"+topv.getKuangfen3Lilunzhi()+
	    			   "' , feimeihui4_lilunzhi='"+topv.getFeimeihui4Lilunzhi()+"' , fenliao5_lilunzhi='"+topv.getFenliao5Lilunzhi()+
	    			   "' , fenliao6_lilunzhi='"+topv.getFenliao6Lilunzhi()+"' , shui1_lilunzhi='"+topv.getShui1Lilunzhi()+
	    			   "' , shui2_lilunzhi='"+topv.getShui2Lilunzhi()+"' , waijiaji1_lilunzhi='"+topv.getWaijiaji1Lilunzhi()+
	    			   "' , waijiaji2_lilunzhi='"+topv.getWaijiaji2Lilunzhi()+"' , waijiaji3_lilunzhi='"+topv.getWaijiaji3Lilunzhi()+
	    			   "' , waijiaji4_lilunzhi='"+topv.getWaijiaji4Lilunzhi()+"' , gongchengmingcheng='"+topv.getGongchengmingcheng()+
	    			   "' , sigongdidian='"+topv.getSigongdidian()+"' , jiaozuobuwei='"+topv.getJiaozuobuwei()+
	    			   "' , shuinipingzhong='"+topv.getShuinipingzhong()+"' , waijiajipingzhong='"+topv.getWaijiajipingzhong()+
	    			   "' , peifanghao='"+topv.getPeifanghao()+"' , qiangdudengji='"+topv.getQiangdudengji()+
	    			   "' , jiaobanshijian='"+topv.getJiaobanshijian()+"' , shebeibianhao='"+topv.getShebeibianhao()+
	    			   "'  , kehuduanbianhao='"+topv.getKehuduanbianhao()+
	    			   "' , gujifangshu='"+topv.getGujifangshu()+"' , banhezhanminchen='"+topv.getBanhezhanminchen()+
	    			   "' , jianchen='"+topv.getJianchen()+"' , smsbaojin='"+topv.getSmsbaojin()+
	    			   "' , smstype='"+topv.getSmstype()+"' , sendtype='"+topv.getSendtype()+
	    			   "' , panshu='"+topv.getPanshu()+"' , pmbegin='"+topv.getPmbegin()+
	    			   "' , pmend='"+topv.getPmend()+"' , smssettype='"+topv.getSmssettype()+
	    			  "' where id="+maxlist.get(0).getId();
	    	   this.updateBySqlString(sql);
		} else {
			HntxiangxixxmaxEntity hxm = new HntxiangxixxmaxEntity();
		   BeanUtils.copyProperties(hxm, topv);
		   this.save(hxm);
		}
			
			
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		}
	
	
      }

		
	}
	
}