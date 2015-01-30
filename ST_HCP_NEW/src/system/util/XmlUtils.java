package system.util;

import org.xml.sax.SAXParseException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlUtils {
	
	private static final Log LOG = LogFactory.getLog(XmlUtils.class);
	public static Element loadDocument(InputStream is) {
		Document doc = null;
		try {
			InputSource xmlInp = new InputSource(is);

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder parser = docBuilderFactory.newDocumentBuilder();
			doc = parser.parse(xmlInp);
			Element root = doc.getDocumentElement();
			root.normalize();
			return root;
		} catch (SAXParseException err) {
			LOG.error("XmlUtils ** 读取配置文件错误, 行 " + err.getLineNumber()
					+ ", uri " + err.getSystemId());
			LOG.error("XmlUtils error: " + err.getMessage());
		} catch (SAXException e) {
			LOG.error("XmlUtils error: " + e);
		} catch (MalformedURLException mfx) {
			LOG.error("XmlUtils error: " + mfx);
		} catch (IOException e) {
			LOG.error("XmlUtils error: " + e);
		} catch (Exception pce) {
			LOG.error("XmlUtils error: " + pce);
		}
		return null;
	}

	public static Element loadDocument(URL url) {
		InputStream is = null;
		try {
			is = url.openStream();
		} catch (IOException e) {
			LOG.error("XmlUtils error: " + e);
			return null;
		}
		return loadDocument(is);
	}

	public static String getSubTagValue(Node node, String subTagName) {
		String returnString = "";
		if (node != null) {
			NodeList children = node.getChildNodes();
			for (int innerLoop = 0; innerLoop < children.getLength(); ++innerLoop) {
				Node child = children.item(innerLoop);
				if ((child != null) && (child.getNodeName() != null)
						&& (child.getNodeName().equals(subTagName))) {
					Node grandChild = child.getFirstChild();
					if (grandChild.getNodeValue() != null)
						return grandChild.getNodeValue();
				}
			}
		}
		return returnString;
	}

	public static String getTagValue(Element root, String tagName) {
		String returnString = "";
		NodeList list = root.getElementsByTagName(tagName);
		for (int loop = 0; loop < list.getLength(); ++loop) {
			Node node = list.item(loop);
			if (node != null) {
				Node child = node.getFirstChild();
				if ((child != null) && (child.getNodeValue() != null))
					return child.getNodeValue();
			}
		}
		return returnString;
	}

	private static String getSubTagAttribute(Element root, String tagName,
			String subTagName, String attribute) {
		String returnString = "";
		NodeList list = root.getElementsByTagName(tagName);
		for (int loop = 0; loop < list.getLength(); ++loop) {
			Node node = list.item(loop);
			if (node != null) {
				NodeList children = node.getChildNodes();
				for (int innerLoop = 0; innerLoop < children.getLength(); ++innerLoop) {
					Node child = children.item(innerLoop);
					if ((child != null) && (child.getNodeName() != null)
							&& (child.getNodeName().equals(subTagName))
							&& (child instanceof Element)) {
						returnString=((Element) child).getAttribute(attribute);
						return returnString;
					}
				}
			}
		}

		return returnString;
	}

	public static String getSubTagValue(Element root, String tagName,
			String subTagName) {
		String returnString = "";
		NodeList list = root.getElementsByTagName(tagName);
		for (int loop = 0; loop < list.getLength(); ++loop) {
			Node node = list.item(loop);
			if (node != null) {
				NodeList children = node.getChildNodes();
				for (int innerLoop = 0; innerLoop < children.getLength(); ++innerLoop) {
					Node child = children.item(innerLoop);
					if ((child != null) && (child.getNodeName() != null)
							&& (child.getNodeName().equals(subTagName))) {
						Node grandChild = child.getFirstChild();
						if (grandChild.getNodeValue() != null)
							return grandChild.getNodeValue();
					}
				}
			}
		}
		return returnString;
	}

}
