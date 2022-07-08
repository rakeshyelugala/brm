package com.org.brm.service.soap;

import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axiom.om.OMDataSource;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.Stub;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.databinding.ADBBean;
import org.apache.axis2.databinding.ADBDataSource;
import org.apache.axis2.databinding.ADBException;
import org.apache.axis2.databinding.types.soapencoding.ExtensionMapper;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.OutInAxisOperation;


@SuppressWarnings("rawtypes")
public class OpcodeOuter extends Stub{
	
	protected AxisOperation[] _operations;
	
	private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;

    private static synchronized java.lang.String getUniqueSuffix(){
        // reset the counter if it is greater than 99999
        if (counter > 99999){
            counter = 0;
        }
        counter = counter + 1; 
        return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
    }


private void populateAxisService() throws AxisFault {

 //creating the Service with a unique name
 _service = new org.apache.axis2.description.AxisService("InfranetWebServiceService" + getUniqueSuffix());
 addAnonymousOperations();

    //creating the operations
   AxisOperation __operation;
    _operations = new AxisOperation[3];
               __operation = new OutInAxisOperation();
           
        __operation.setName(new QName("http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices", "opcodeWithFlags"));
    _service.addOperation(__operation);
    
        _operations[0]=__operation;
        
               __operation = new OutInAxisOperation();
            
        __operation.setName(new QName("http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices", "test"));
    _service.addOperation(__operation);
    
        _operations[1]=__operation;
        
               __operation = new OutInAxisOperation();
            
        __operation.setName(new QName("http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices", "opcode"));
    _service.addOperation(__operation);
    
        _operations[2]=__operation;
        
    }
	
//populates the faults
private void populateFaults(){
     


}

/**
  *Constructor that takes in a configContext
  */

public OpcodeOuter(ConfigurationContext configurationContext,
   String targetEndpoint)
   throws AxisFault {
     this(configurationContext,targetEndpoint,false);
}


/**
 * Constructor that takes in a configContext  and useseperate listner
 */
public OpcodeOuter(ConfigurationContext configurationContext,
    String targetEndpoint, boolean useSeparateListener)
    throws AxisFault {
     //To populate AxisService
     populateAxisService();
     populateFaults();

    _serviceClient = new ServiceClient(configurationContext,_service);
    

    _serviceClient.getOptions().setTo(new EndpointReference(
            targetEndpoint));
    _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
    

}

/**
 * Default Constructor
 */
public OpcodeOuter(ConfigurationContext configurationContext) throws AxisFault {
    
                this(configurationContext,"http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices" );
            
}

/**
 * Default Constructor
 */
public OpcodeOuter() throws AxisFault {
                this("http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices" );
            
}

/**
 * Constructor taking the target endpoint
 */
public OpcodeOuter(String targetEndpoint) throws AxisFault {
    this(null,targetEndpoint);
}
	
	public static class Opcode implements ADBBean{
		
		public static final QName MY_QNAME = new QName(
                "http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices",
                "opcode",
                "ns1");
		
		protected String localOpcode;
		
		protected String localInputXML;
		
		protected String localM_SchemaFile ;
		
		public void setLocalOpcode(String localOpcode) {
			this.localOpcode = localOpcode;
		}
		
		public  String getLocalOpcode(){
            return localOpcode;
        }
		
		public void setLocalInputXML(String localInputXML) {
			this.localInputXML = localInputXML;
		}
		
		public  String getLocalInputXML(){
            return localInputXML;
        }
		
        public String getM_SchemaFile(){
            return localM_SchemaFile;
        }

        public void setM_SchemaFile(String localM_SchemaFile){
            this.localM_SchemaFile=localM_SchemaFile;
        }

		@Override
		public OMElement getOMElement(QName arg0, OMFactory arg1) throws ADBException {

            OMDataSource dataSource =
                    new ADBDataSource(this,MY_QNAME);
            return arg1.createOMElement(dataSource,MY_QNAME);
         
     }

		public XMLStreamReader getPullParser(QName arg0) throws XMLStreamException {

            ArrayList elementList = new ArrayList();
            ArrayList attribList = new ArrayList();

           return new ADBXMLStreamReaderImpl(arg0, elementList.toArray(), attribList.toArray());
       
		}

		@Override
		public void serialize(QName arg0, XMLStreamWriter arg1) throws XMLStreamException, ADBException {
			serialize(arg0,arg1,false);
			
		}

		@Override
		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2) throws XMLStreamException, ADBException {
            
            java.lang.String prefix = null;
            java.lang.String namespace = null;

                prefix = arg0.getPrefix();
                namespace = arg0.getNamespaceURI();
                writeStartElement(prefix, namespace, arg0.getLocalPart(), arg1);
            
              if (arg2){
               java.lang.String namespacePrefix = registerPrefix(arg1,"http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices");
               if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                   writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                       namespacePrefix+":test",
                       arg1);
               } else {
                   writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                       "test",
                       arg1);
               }
               }
           
              arg1.writeEndElement();
    }
		
		private static String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices")){
                return "ns1";
            }
            return BeanUtil.getUniquePrefix();
        }

		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
if (writerPrefix != null) {
xmlWriter.writeStartElement(namespace, localPart);
} else {
if (namespace.length() == 0) {
prefix = "";
} else if (prefix == null) {
prefix = generatePrefix(namespace);
}

xmlWriter.writeStartElement(prefix, localPart, namespace);
xmlWriter.writeNamespace(prefix, namespace);
xmlWriter.setPrefix(prefix, namespace);
}
}

/**
* Util method to write an attribute with the ns prefix
*/
private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
             java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
if (xmlWriter.getPrefix(namespace) == null) {
xmlWriter.writeNamespace(prefix, namespace);
xmlWriter.setPrefix(prefix, namespace);
}
xmlWriter.writeAttribute(namespace,attName,attValue);
}

/**
* Util method to write an attribute without the ns prefix
*/
private void writeAttribute(java.lang.String namespace,java.lang.String attName,
             java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
if (namespace.equals("")) {
xmlWriter.writeAttribute(attName,attValue);
} else {
registerPrefix(xmlWriter, namespace);
xmlWriter.writeAttribute(namespace,attName,attValue);
}
}
private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
    java.lang.String prefix = xmlWriter.getPrefix(namespace);
    if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
            java.lang.String uri = nsContext.getNamespaceURI(prefix);
            if (uri == null || uri.length() == 0) {
                break;
            }
            prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
    }
    return prefix;
}
		public static class Factory{

	        /**
	        * static method to create the object
	        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
	        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
	        * Postcondition: If this object is an element, the reader is positioned at its end element
	        *                If this object is a complex type, the reader is positioned at the end element of its outer element
	        */
	        public static Opcode parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
	            Opcode object =
	                new Opcode();

	            int event;
	            java.lang.String nillableValue = null;
	            java.lang.String prefix ="";
	            java.lang.String namespaceuri ="";
	            try {
	                
	                while (!reader.isStartElement() && !reader.isEndElement())
	                    reader.next();

	                
	                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
	                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
	                        "type");
	                  if (fullTypeName!=null){
	                    java.lang.String nsPrefix = null;
	                    if (fullTypeName.indexOf(":") > -1){
	                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
	                    }
	                    nsPrefix = nsPrefix==null?"":nsPrefix;

	                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
	                    
	                            if (!"opcode".equals(type)){
	                                //find namespace for the prefix
	                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
	                                return (Opcode)ExtensionMapper.getTypeObject(
	                                     nsUri,type,reader);
	                              }
	                        

	                  }
	                

	                }

	                // Note all attributes that were handled. Used to differ normal attributes
	                // from anyAttributes.
	                java.util.Vector handledAttributes = new java.util.Vector();
	                

	                
	                    
	                    reader.next();
	                
	                                    
	                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
	                                
	                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","opcode").equals(reader.getName())){
	                                
	                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
	                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
	                                    
	                                    java.lang.String content = reader.getElementText();
	                                              object.setLocalOpcode(
	                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
	                                            
	                                       } else {
	                                           
	                                           reader.getElementText(); // throw away text nodes if any.
	                                       }
	                                        reader.next();
	                                    
	                              }  // End of if for expected property start element
	                                
	                                else{
	                                    // A start element we are not expecting indicates an invalid parameter was passed
	                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
	                                }
	                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
	                                
	                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","inputXML").equals(reader.getName())){
	                                
	                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
	                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
	                                    

	                                    java.lang.String content = reader.getElementText();
	                                    
	                                              object.setLocalInputXML(
	                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
	                                            
	                                       } else {
	                                           
	                                           
	                                           reader.getElementText(); // throw away text nodes if any.
	                                       }
	                                      
	                                        reader.next();
	                                    
	                              }  // End of if for expected property start element
	                                
	                                else{
	                                    // A start element we are not expecting indicates an invalid parameter was passed
	                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
	                                }
	                            
	                                    
	                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
	                                
	                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","m_SchemaFile").equals(reader.getName())){
	                                
	                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
	                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
	                                    

	                                    java.lang.String content = reader.getElementText();
	                                    
	                                              object.setM_SchemaFile(
	                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
	                                            
	                                       } else {
	                                           
	                                           
	                                           reader.getElementText(); // throw away text nodes if any.
	                                       }
	                                      
	                                        reader.next();
	                                    
	                              }  // End of if for expected property start element
	                                
	                                else{
	                                    // A start element we are not expecting indicates an invalid parameter was passed
	                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
	                                }
	                              
	                            while (!reader.isStartElement() && !reader.isEndElement())
	                                reader.next();
	                            
	                                if (reader.isStartElement())
	                                // A start element we are not expecting indicates a trailing invalid property
	                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
	                            
	            } catch (javax.xml.stream.XMLStreamException e) {
	                throw new java.lang.Exception(e);
	            }

	            return object;
	        }

	        }
	}
	
	 public static class OpcodeResponse implements ADBBean{
		 
		 protected String localOpcodeReturn ;
         
         public String getOpcodeReturn(){
             return localOpcodeReturn;
         }

             public void setOpcodeReturn(String param){
            	 	this.localOpcodeReturn=param;                     
             }

		@Override
		public OMElement getOMElement(QName arg0, OMFactory arg1) throws ADBException {
			// TODO Auto-generated method stub
			return null;
		}

		public XMLStreamReader getPullParser(QName arg0) throws XMLStreamException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void serialize(QName arg0, XMLStreamWriter arg1) throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2) throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}
		 
	 }

	public OpcodeResponse opcode(Opcode opcode) throws AxisFault {
		
        org.apache.axis2.context.MessageContext _messageContext = null;
        //AxisOperation[] _operations = null;
        try{
         OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
        _operationClient.getOptions().setAction("http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices/InfranetWebService/opcodeRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
        
            addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");

        // create a message context
        _messageContext = new org.apache.axis2.context.MessageContext();

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
                                              env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                            		  opcode,
                                              optimizeContent(new javax.xml.namespace.QName("http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices",
                                              "opcode")), new javax.xml.namespace.QName("http://172.21.0.36:9004/infranetwebsvc/services/BRMBaseServices",
                                              "opcode"));
                                          
  //adding SOAP soap_headers
   _serviceClient.addHeadersToEnvelope(env);
  // set the message context with that soap envelope
  _messageContext.setEnvelope(env);

  // add the message contxt to the operation client
  _operationClient.addMessageContext(_messageContext);

  //execute the operation client
  _operationClient.execute(true);

   
         org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                     org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
          org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
          
          
                          java.lang.Object object = fromOM(
                                       _returnEnv.getBody().getFirstElement() ,
                                       OpcodeResponse.class,
                                        getEnvelopeNamespaces(_returnEnv));

                         
                                  return (OpcodeResponse)object;
                             
   }catch(org.apache.axis2.AxisFault f){

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      /*if (faultElt!=null){
          if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"opcode"))){
              //make the fault by reflection
              try{
                  java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"opcode"));
                  java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                  java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                  java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                  //message class
                  java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"opcode"));
                  java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                  java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                  java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                             new java.lang.Class[]{messageClass});
                  m.invoke(ex,new java.lang.Object[]{messageObject});
                  

                  throw new java.rmi.RemoteException(ex.getMessage(), ex);
              }catch(Exception e){
                 // we cannot intantiate the class - throw the original Axis fault
                  throw f;
              }
          }else{
              throw f;
          }
      }else{
          throw f;
      }*/
      } finally {
          if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
          }
      }
		return null;
  }
	
	private QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        
        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
    
    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, Opcode param, boolean optimizeContent, QName methodQName)
            throws AxisFault{
                 
                        try{
                                org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                emptyEnvelope.getBody().addChild(param.getOMElement(Opcode.MY_QNAME,factory));
                                return emptyEnvelope;
                            } catch(org.apache.axis2.databinding.ADBException e){
                                throw org.apache.axis2.AxisFault.makeFault(e);
                            }
            }
    
    private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }
    
    private  java.lang.Object fromOM(
            org.apache.axiom.om.OMElement param,
            java.lang.Class type,
            java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

            try {
            
                    if (Opcode.class.equals(type)){
                            return Opcode.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                        

                    }
                
            } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
            }
               return null;
            }

}
