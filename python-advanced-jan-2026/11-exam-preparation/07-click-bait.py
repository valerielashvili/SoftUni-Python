from collections import deque


links_engagement = deque(int(e) for e in input().split()) # FIFO
articles_popularity = [int(p) for p in input().split()] # LIFO
target_engagement = int(input())
final_feed = []

while links_engagement and articles_popularity:
    engagement_score = links_engagement.popleft()
    popularity_score = articles_popularity.pop()

    if engagement_score > popularity_score:
        remainder = engagement_score % popularity_score
        final_feed.append(-remainder)
        if remainder != 0:
            links_engagement.append(remainder * 2)

    elif popularity_score > engagement_score:
        remainder = popularity_score % engagement_score
        final_feed.append(remainder)
        if remainder != 0:
            articles_popularity.append(remainder * 2)

    elif engagement_score == popularity_score:
        final_feed.append(0)

total_engagement = sum(final_feed)

print(f"Final Feed: {', '.join(map(str, final_feed))}")

if total_engagement >= target_engagement:
    print(f"Goal achieved! Engagement Value: {total_engagement}")
else:
    shortfall = target_engagement - total_engagement
    print(f"Goal not achieved! Short by: {shortfall}")
