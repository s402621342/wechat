package service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import entity.Information;
import entity.OutLine;
import entity.Procedure;
import entity.View;
import service.checkService;
@Service
public class checkServiceImpl implements checkService{

	public Information getInformation(long id) {
		// TODO Auto-generated method stub
		String title="关于同意中共上海先进半导体制造股份有限公司委员会增补委员选举结果的批复";
		String number="沪化区投委(2015)19号";
		String draftDate="2015-12-21";
		String secret="一般";
		String urgency="一般";
		String drafter="唐隆昱";
		String draftVerification="吴建华";
		String subject="党建工作 增补委员 选举结果 批复";
		String employer="中共上海先进半导体制造股份有限公司委员会";
		String report="上海化学工业区发展有限公司党委";
		String copy="";
		String printDate="　 印发    共印3份";
		String remark="";
		String state="审批";
		String text="http://bos.wenku.bdimg.com/v1/wenku15//979472c0df1e87d27408ed7a4f20ab86?responseContentDisposition=attachment%3B%20filename%3D%22%B0%D9%B6%C8%CE%C4%B5%B5.doc.doc%22&responseContentType=application%2Foctet-stream&responseCacheControl=no-cache&authorization=bce-auth-v1%2Ffa1126e91489401fa7cc85045ce7179e%2F2016-07-26T04%3A58%3A40Z%2F3600%2Fhost%2F61032335256fbf835d8f3f0babd847e9365961edcb73806ee271c96d5f5cf7bd&token=7c9d8434d953370d8a25ac15eed10a24174c988d84d54dd3e641c284ca01d4b5&expire=2016-07-26T05:58:40Z";
		Map<String, String> attachment=new HashMap<String, String>();
		attachment.put("2015年度项目建设审计情况汇总.docx", "http://bos.wenku.bdimg.com/v1/wenku15//979472c0df1e87d27408ed7a4f20ab86?responseContentDisposition=attachment%3B%20filename%3D%22%B0%D9%B6%C8%CE%C4%B5%B5.doc.doc%22&responseContentType=application%2Foctet-stream&responseCacheControl=no-cache&authorization=bce-auth-v1%2Ffa1126e91489401fa7cc85045ce7179e%2F2016-07-26T04%3A58%3A40Z%2F3600%2Fhost%2F61032335256fbf835d8f3f0babd847e9365961edcb73806ee271c96d5f5cf7bd&token=7c9d8434d953370d8a25ac15eed10a24174c988d84d54dd3e641c284ca01d4b5&expire=2016-07-26T05:58:40Z");
		List<Procedure> procedures=new ArrayList<Procedure>();
		procedures.add(new Procedure(1, "2015-12-21 14:34", "唐隆昱", "综合办公室", "起草"));
		List<View> examineView=new ArrayList<View>();
		examineView.add(new View("吴建华同志", "2015-12-21 14:38", "请党委委员阅。", "http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"));
		List<View> readView=new ArrayList<View>();
		readView.add(new View("戴鲲同志", "2015-12-22 10:34", "阅", "http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"));
		Information information=new Information(id,title, number, draftDate, secret, urgency, drafter, draftVerification, subject,
				employer, report, copy, printDate, remark, state, text, attachment, procedures, examineView, readView);
		return information;
	}

	public List<OutLine> getOutLines(String username) {
		// TODO Auto-generated method stub
		List<OutLine> outLines=new ArrayList<OutLine>();
		outLines.add(new OutLine(1, "关于同意中共上海先进半导体制造股份有限公司委员会增补委员选举结果的批复","2015-12-21 14:38", "唐隆昱", "审批中"));
		return outLines;
	}

}
