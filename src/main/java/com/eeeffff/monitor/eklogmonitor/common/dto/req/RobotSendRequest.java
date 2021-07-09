package com.eeeffff.monitor.eklogmonitor.common.dto.req;

import java.util.List;

/**
 * 钉钉自定义机器人API封装 参考链接:https://ding-doc.dingtalk.com/doc?spm=a1zb9.8233112.0.0.340c3a88sgMlJJ#/serverapi2/qf2nxq
 * 
 * @author fenglibin
 *
 */
public class RobotSendRequest {
    /**
     * 消息类型
     */
    private String msgtype;

    private At at;

    private MarkDown markdown;

    private Text text;

    private Link link;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public At getAt() {
        return at;
    }

    public void setAt(At at) {
        this.at = at;
    }

    public MarkDown getMarkdown() {
        return markdown;
    }

    public void setMarkdown(MarkDown markdown) {
        this.markdown = markdown;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public final static class At {
        /**
         * 是否@所有人
         */
        private Boolean isAtAll;

        /**
         * 被@人的手机号
         */
        private List<String> atMobiles;

        public Boolean getIsAtAll() {
            return isAtAll;
        }

        public void setIsAtAll(Boolean atAll) {
            isAtAll = atAll;
        }

        public List<String> getAtMobiles() {
            return atMobiles;
        }

        public void setAtMobiles(List<String> atMobiles) {
            this.atMobiles = atMobiles;
        }
    }

    public final static class Text {
        /**
         * 消息内容
         */
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public final static class MarkDown {
        /**
         * 首屏会话透出的展示内容
         */
        private String title;

        /**
         * markdown格式的消息
         */
        private String text;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public final static class Link{
        /**
         * 消息标题
         */
        private String title;

        /**
         * 消息内容
         */
        private String text;

        /**
         * 点击消息跳转的URL
         */
        private String messageUrl;

        /**
         * 图片URL
         */
        private String picUrl;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getMessageUrl() {
			return messageUrl;
		}

		public void setMessageUrl(String messageUrl) {
			this.messageUrl = messageUrl;
		}

		public String getPicUrl() {
			return picUrl;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}        
        
    }
}