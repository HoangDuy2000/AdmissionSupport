import { useContext, useEffect, useState } from "react";
import Apis, { authApis, endpoint } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import { Button, Col, Form, ListGroup, Row } from "react-bootstrap";
import { Link, useParams } from "react-router-dom";
import { MyUserContext } from "../App";
import Moment from "react-moment";

const NewsDetails = () => {
    const [user, ] = useContext(MyUserContext);
    const {newsId} = useParams();
    const [news, setNews] = useState(null);
    const [comments, setComments] = useState(null);
    const [content, setContent] = useState();

    useEffect(() => {
        const loadNews = async () => {
            let {data} = await Apis.get(endpoint['details'](newsId));
            setNews(data);
        }

        const loadComments = async () => {
            let {data} = await Apis.get(endpoint['comments'](newsId));
            setComments(data);
        }

        loadNews();
        loadComments();

    }, []);

    const addComment = () =>{
        const process = async () => {
            let {data} = await authApis().post(endpoint['add-comment'], {
                "content": content,
                "news": news.id
            });

            setComments([...comments, data]);
        }

        process();
    }

    if (news === null || comments === null)
        return <MySpinner /> ;

    let url = `/login?next=/news/${newsId}`;
    return <>
            <h1 className="text-center text-info mt-2">{news.title}</h1>
            <Row>
                <Col md={5} xs={6}>
                    <p>{news.date}</p>
                    <p>{news.content}</p>
                </Col>
            </Row>
            <hr />


            {user===null?<p>Vui lòng <Link to={url}>đăng nhập</Link> để bình luận! </p>:<>
            <Form.Control as="textarea" aria-label="With textarea" value={content} onChange={e => setContent(e.target.value)} placeholder="Nội dung bình luận" />
            <Button onClick={addComment} className="mt-2" variant="info">Bình luận</Button>
            </>}
            <hr />
            <ListGroup>
                {comments.map(c => <ListGroup.Item id={c.id}>
                            {c.accountId.username} - {c.content} - <Moment locale="vi" fromNow>{c.createdDate}</Moment>
                        </ListGroup.Item>)
                }
            </ListGroup>
        </>
}

export default NewsDetails;