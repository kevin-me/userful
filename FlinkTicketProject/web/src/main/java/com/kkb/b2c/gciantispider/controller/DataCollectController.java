package com.kkb.b2c.gciantispider.controller;

import com.kkb.b2c.gciantispider.model.Datacollect;
import com.kkb.b2c.gciantispider.model.DatacollectView;
import com.kkb.b2c.gciantispider.pageUtil.LinkJsonVO;
import com.kkb.b2c.gciantispider.service.IDataCollectService;
import com.kkb.b2c.gciantispider.util.Constants;
import com.kkb.b2c.gciantispider.util.JedisConnectionUtil;
import com.kkb.b2c.gciantispider.util.JsonResolveUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 数据采集控制器
 *
 */
@Controller
@RequestMapping("/dataCollect")
public class DataCollectController {
	
	private final static Logger logger = Logger.getLogger(DataCollectController.class.getName());
	
	@Autowired
	private IDataCollectService dataCollectService;
	/**
	 * 
	 * 获取所有服务器信息
	 * @return
	 */
	@RequestMapping(value="/getDataCollect",method = RequestMethod.GET)
    @ResponseBody
    public List<DatacollectView> getDataCollect(HttpServletRequest request){
		 //构建保存DatacollectView对象的集合
		List<DatacollectView> dataCollectViewList = new ArrayList<DatacollectView>();
		try{
			//实例化 redis 集群
			JedisCluster jedisCluster = JedisConnectionUtil.getJedisCluster();

			//从数据库表 dataCollect 中拿出所有数据
			List<Datacollect> dataCollectList = dataCollectService.getDataCollect();
			//遍历
			for (Datacollect datacollect : dataCollectList) {
				 //获取保存当前活跃连接数的最后一个key
				String last = JedisConnectionUtil.keys(jedisCluster, Constants.CSANTI_MONITOR_AP +"*").last();
				//获取key对应的value 类似于 {"activeNumMap":{"192.168.200.100":16}}
				String value = jedisCluster.get(last);
				//json串转化为LinkJsonVO对象
				LinkJsonVO resolveLinkJson = JsonResolveUtil.resolveLinkJson(value);
				//获取bean中的activeNumMap------{"192.168.200.100":16}
				Map<String,Integer> map2 = resolveLinkJson.getActiveNumMap();
				//获取所有的key，每一个key就是ip地址
				Set<String> keySet = map2.keySet();

				//遍历
				for (String key : keySet) {
					//获取正在运行的服务id，在mysql中存储的数据
					if (key.equals(datacollect.getServerName())) {

						DatacollectView datacollectView = new DatacollectView();
						 //获取活跃的连接数
						datacollectView.setActiveNum(map2.get(key));
						 //获取id
						datacollectView.setId(datacollect.getId());
                        //获取昨天采集的数据量
						datacollectView.setYesterdayNum(datacollect.getYesterdayNum());
						//获取前天采集的数据量
						datacollectView.setBeforeYesterdayNum(datacollect.getBeforeYesterdayNum());
						//获取前三天采集的数据量
						datacollectView.setLastThreeDaysNum(datacollect.getLastThreeDaysNum());
						//获取服务器ip地址
						datacollectView.setServerName(datacollect.getServerName());
						//添加到list集合
						dataCollectViewList.add(datacollectView);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return dataCollectViewList;
	}
	/**
	 * 
	 * 删除服务器
	 * @return
	 */
	@RequestMapping(value="/deleteServer",method = RequestMethod.GET)
    @ResponseBody
	public Map<String,Object> deleteServer(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		String id = request.getParameter("id");
		try{
			dataCollectService.deleteServer(id);
			map.put("result", "删除成功");
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return map;
	}
	/**
	 * 
	 * 修改脚本
	 * @return
	 */
	@RequestMapping(value="/modifyData",method = RequestMethod.GET)
    @ResponseBody
	public Map<String,Object> modifyData(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		String id = request.getParameter("id");
		String newScript = request.getParameter("newScript");
		try{
			dataCollectService.modifyData(id, newScript);
			map.put("result", "修改成功");
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return map;
	}
	
	/**
	 * 
	 * 获取脚本(用于修改时前端展示)
	 * @return
	 */
	@RequestMapping(value="/getScript",method = RequestMethod.GET)
    @ResponseBody
    public Datacollect getScript(HttpServletRequest request){
		Datacollect datacollect = null;
		String id = request.getParameter("id");
		try{
			datacollect = dataCollectService.get(id);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return datacollect;
	}
}
