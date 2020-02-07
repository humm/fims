package com.hoomoomoo.fims.app.util;

import com.hoomoomoo.fims.app.model.SysInterfaceModel;
import com.hoomoomoo.fims.app.model.SysSqlMode;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.*;

/**
 * @author humm23693
 * @description 文件读取工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2019/11/23
 */

public class SysFileUtils {

    /**
     * 读取文件内容
     *
     * @param file
     * @return
     */
    public static String getContent(File file) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String readContent = null;
            while ((readContent = bufferedReader.readLine()) != null) {
                content.append(readContent).append(NEXT_LINE);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * 获取配置sql
     *
     * @param filePath
     * @return
     */
    public static ConcurrentHashMap<String, SysSqlMode> getConfigSql(String filePath) {
        ConcurrentHashMap<String, SysSqlMode> xmlMap = new ConcurrentHashMap();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(filePath);
            DOMReader xmlReader = new DOMReader();
            org.dom4j.Document doc = xmlReader.read(document);
            Element root = doc.getRootElement();
            List<Element> elementList = root.elements();
            for (int i = 0; i < elementList.size(); i++) {
                Element element = elementList.get(i);
                String id = element.attribute(SQL_ID).getValue();
                String model = SQL_MODEL_SELECT;
                String value = element.getTextTrim();
                if (StringUtils.isBlank(id)) {
                    throw new RuntimeException(String.format(TIP_SQL_ID, id));
                }
                if (StringUtils.isBlank(value)) {
                    throw new RuntimeException(String.format(TIP_SQL_VALUE, id));
                }
                if (element.attribute(SQL_MODEL) != null) {
                    model = element.attribute(SQL_MODEL).getValue();
                }
                if (xmlMap.containsKey(id)) {
                    throw new RuntimeException(String.format(TIP_SQL_ID_EXIST, id));
                }
                xmlMap.put(id, new SysSqlMode(id, model, value));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xmlMap;
    }

    /**
     * 获取邮件信息
     *
     * @param xml
     * @return
     */
    public static SysInterfaceModel getMailXmlToBean(String xml) {
        Map<String, String> content = new HashMap<>(16);
        try {
            xml = xml.replace(LESS_THAN_SEMICOLON, LESS_THAN).replace(GREATER_THAN_SEMICOLON, GREATER_THAN).replace(NBSP, STR_EMPTY);
            org.dom4j.Document document = DocumentHelper.parseText(xml);
            org.dom4j.Element root = document.getRootElement();
            Iterator<org.dom4j.Element> iterator = root.elementIterator();
            while (iterator.hasNext()) {
                org.dom4j.Element element = iterator.next();
                content.put(element.getName(), element.getTextTrim());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return (SysInterfaceModel)SysBeanUtils.mapToBean(SysInterfaceModel.class, content);
    }
}
