package dtos;

import java.io.Serializable;

public class SNSDto implements Serializable {

    public String Type;
    public String MessageId;
    public String TopicArn;
    public String Timestamp;
    public String SignatureVersion;
    public String Signature;
    public String UnsubscribeURL;
    public String Message;
    public String SigningCertURL;
    public String Subject;

}
