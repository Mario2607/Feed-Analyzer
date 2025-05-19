package TGMSEWFeedAnalyzer;

public class AnalyzedText implements Comparable<AnalyzedText> {
    private String text;
    private double sentiment;

    public AnalyzedText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public double getSentiment() {
        return sentiment;
    }

    @Override
    public int compareTo(AnalyzedText o) {
        if (o == null)
            return -1;
        if (this.equals(o))
            return 0;
        int ret = this.text.compareTo(o.text);
        if (ret != 0)
            return ret;
        ret = (int) this.sentiment - (int) o.sentiment;
        if(ret != 0)
            return ret;
        return 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + (int) sentiment;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        AnalyzedText other = (AnalyzedText) obj;
        if (text == null) {
            if (other.text != null) {
                return false;
            }
        } else if (!text.equals(other.text)) {
            return false;
        }
        if (sentiment != other.sentiment) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Text: " + this.text + ", Sentiment: " + this.sentiment;
    }
}
