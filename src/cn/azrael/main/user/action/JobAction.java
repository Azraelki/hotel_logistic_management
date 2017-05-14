package cn.azrael.main.user.action;

import java.util.List;

import javax.annotation.Resource;





import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.entity.Job;
import cn.azrael.main.user.service.JobService;


public class JobAction extends BaseAction{
	@Resource
	private JobService jobService;
	private List<Job> jobList;
	private Job job;
	private String message;
	/**
	 * 职位信息展示
	 */
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(Job.class, "j");
		try {
			System.out.println(pageNo);
			pageResult = jobService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "info";
	}
	/**
	 *添加职位信息 
	 */
	public String add() throws Exception{
		if(job!=null&&job.getName()!=null){
			System.out.println(job);
			try {
				int max = 0;
				for (Job j : jobService.findObjects()) {
					if(j.getId() > max){
						max = j.getId();
					}
				}
				job.setId(max+1);
				jobService.save(job);
			} catch (Exception e) {
				message = "添加失败";
				throw new Exception(e.getMessage());
			}
			message = "添加成功！";
			return "list";
		}
		return "add";
	}
	/**
	 * 编辑页面
	 */
	public String editUI(){
		if(job!=null && job.getId()!=null){
			job = jobService.findObjectById(job.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑
	 */
	public String edit(){
		try {
			if(job!=null){
				jobService.update(job);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	/**
	 * 删除单个
	 */
	public String delete() throws Exception{
		if(job!=null && job.getId()!=null){
			try {
				System.out.println(job.getId());
				jobService.deleteAndRole(job.getId());
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		return "list";
	}
	/**
	 * 批量删除
	 */
	public String deleteSelected() throws Exception{
		if(selectedRow!=null){
			for(String s:selectedRow){
				try {
					jobService.deleteAndRole(Integer.parseInt(s));
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
		return "list";
	}
	
	
	public List<Job> getJobList() {
		return jobList;
	}
	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
