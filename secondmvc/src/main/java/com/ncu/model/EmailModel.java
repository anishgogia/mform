package com.ncu.model;


	public class EmailModel {
		private String mailTo;
		private String subject;
		private String message;
		private String fileName;
		
		
		public EmailModel() {
			super();
			// TODO Auto-generated constructor stub
		}

		public EmailModel(String mailTo, String subject, String message, String fileName) {
			super();
			this.mailTo = mailTo;
			this.subject = subject;
			this.message = message;
			this.fileName = fileName;
		}

		public String getFileName() {
			return fileName;
		}


		public void setFileName(String fileName) {
			this.fileName = fileName;
		}


		public String getMailTo() {
			return mailTo;
		}


		public void setMailTo(String mailTo) {
			this.mailTo = mailTo;
		}


		public String getSubject() {
			return subject;
		}


		public void setSubject(String subject) {
			this.subject = subject;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}


		@Override
		public String toString() {
			return "EmailModel [mailTo=" + mailTo + ", Subject=" + subject + ", message=" + message + "]";
		}
		
		
		
		

	}
